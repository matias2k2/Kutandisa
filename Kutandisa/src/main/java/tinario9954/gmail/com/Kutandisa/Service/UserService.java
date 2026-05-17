package tinario9954.gmail.com.Kutandisa.Service;

import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
 
import jakarta.transaction.Transactional;
import tinario9954.gmail.com.Kutandisa.DTOS.auth.AuthResponseDTO;
import tinario9954.gmail.com.Kutandisa.DTOS.auth.LoginRequestDTO;
import tinario9954.gmail.com.Kutandisa.DTOS.auth.RegisterRequestDTO;
import tinario9954.gmail.com.Kutandisa.Enum.RoleNome;
import tinario9954.gmail.com.Kutandisa.Model.Role;
import tinario9954.gmail.com.Kutandisa.Model.User;
import tinario9954.gmail.com.Kutandisa.Repository.RoleRepository;
import tinario9954.gmail.com.Kutandisa.Repository.UserRepository;
import tinario9954.gmail.com.Kutandisa.Security.JwtUtil;
 

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository _userRepository;

    @Autowired
    private RoleRepository _roleRepository;

    @Autowired
    private PasswordEncoder _passwordEncoder;

    @Autowired
    private JwtUtil _jwtUtil;

    // ─────────────────────────────────────────────
    //  REGISTO
    // ─────────────────────────────────────────────

    public AuthResponseDTO registar(RegisterRequestDTO dto) {

        if (_userRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("E-mail já registado: " + dto.email());
        }

        if (_userRepository.existsByTelefone(dto.telefone())) {
            throw new IllegalArgumentException("Telefone já registado: " + dto.telefone());
        }

        Role role = _roleRepository.findByNome(dto.role())
                .orElseThrow(() -> new IllegalArgumentException("Role não encontrada: " + dto.role()));

        User user = new User();
        user.setNomeCompleto(dto.nomeCompleto());
        user.setEmail(dto.email());
        user.setTelefone(dto.telefone());
        user.setPassword(_passwordEncoder.encode(dto.password()));
        user.setRole(role);
        user.setActivo(true);

        User saved = _userRepository.save(user);

        String token = _jwtUtil.gerarToken(
                saved.getId(),
                saved.getEmail(),
                saved.getRole().getNome().name()
        );

        return new AuthResponseDTO(token, saved.getId(), saved.getNomeCompleto(), saved.getEmail(), saved.getRole().getNome().name());
    }

    // ─────────────────────────────────────────────
    //  LOGIN
    // ─────────────────────────────────────────────

    public AuthResponseDTO login(LoginRequestDTO dto) {

        User user = _userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new IllegalArgumentException("Credenciais inválidas."));

        if (!user.getActivo()) {
            throw new IllegalStateException("Conta desactivada. Contacte o suporte.");
        }

        if (!_passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new IllegalArgumentException("Credenciais inválidas.");
        }

        String token = _jwtUtil.gerarToken(
                user.getId(),
                user.getEmail(),
                user.getRole().getNome().name()
        );

        return new AuthResponseDTO(token, user.getId(), user.getNomeCompleto(), user.getEmail(), user.getRole().getNome().name());
    }

    // ─────────────────────────────────────────────
    //  LEITURA
    // ─────────────────────────────────────────────

    public List<User> listarTodos() {
        return _userRepository.findAll();
    }

    public User buscarPorId(Long id) {
        return _userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilizador não encontrado com id: " + id));
    }

    public Optional<User> buscarPorEmail(String email) {
        return _userRepository.findByEmail(email);
    }

    public Optional<User> buscarPorTelefone(String telefone) {
        return _userRepository.findByTelefone(telefone);
    }

    public List<User> buscarPorNome(String nome) {
        return _userRepository.findByNomeCompletoContainingIgnoreCase(nome);
    }

    public List<User> listarPorRole(String nomeRole) {
        return _userRepository.findByRole_Nome(parseRole(nomeRole));
    }

    public List<User> listarActivos() {
        return _userRepository.findByActivo(true);
    }

    public List<User> listarInactivos() {
        return _userRepository.findByActivo(false);
    }

    public List<User> listarActivosPorRole(String nomeRole) {
        return _userRepository.findActivosByRole(parseRole(nomeRole));
    }

    public Long contarPorRole(String nomeRole) {
        return _userRepository.countByRole(parseRole(nomeRole));
    }

    // ─────────────────────────────────────────────
    //  ACTUALIZAÇÃO
    // ─────────────────────────────────────────────

    public User actualizarPerfil(Long id, String nomeCompleto, String telefone, String fotoPerfil) {

        User user = buscarPorId(id);

        if (nomeCompleto != null && !nomeCompleto.isBlank()) {
            user.setNomeCompleto(nomeCompleto);
        }

        if (telefone != null && !telefone.isBlank()) {
            if (!telefone.equals(user.getTelefone()) && _userRepository.existsByTelefone(telefone)) {
                throw new IllegalArgumentException("Telefone já em uso: " + telefone);
            }
            user.setTelefone(telefone);
        }

        if (fotoPerfil != null && !fotoPerfil.isBlank()) {
            user.setFotoPerfil(fotoPerfil);
        }

        return _userRepository.save(user);
    }

    public void alterarPassword(Long id, String passwordActual, String novaPassword) {

        User user = buscarPorId(id);

        if (!_passwordEncoder.matches(passwordActual, user.getPassword())) {
            throw new IllegalArgumentException("Password actual incorrecta.");
        }

        user.setPassword(_passwordEncoder.encode(novaPassword));
        _userRepository.save(user);
    }

    public User alterarRole(Long userId, String nomeRole) {

        User user = buscarPorId(userId);

        Role role = _roleRepository.findByNome(parseRole(nomeRole))
                .orElseThrow(() -> new IllegalArgumentException("Role não encontrada: " + nomeRole));

        user.setRole(role);
        return _userRepository.save(user);
    }

    // ─────────────────────────────────────────────
    //  ACTIVAÇÃO / DESACTIVAÇÃO
    // ─────────────────────────────────────────────

    public User activar(Long id) {
        User user = buscarPorId(id);
        user.setActivo(true);
        return _userRepository.save(user);
    }

    public User desactivar(Long id) {
        User user = buscarPorId(id);
        user.setActivo(false);
        return _userRepository.save(user);
    }

    // ─────────────────────────────────────────────
    //  ELIMINAÇÃO
    // ─────────────────────────────────────────────

    public void eliminar(Long id) {
        if (!_userRepository.existsById(id)) {
            throw new IllegalArgumentException("Utilizador não encontrado com id: " + id);
        }
        _userRepository.deleteById(id);
    }

    // ─────────────────────────────────────────────
    //  UTILITÁRIOS
    // ─────────────────────────────────────────────

    public boolean emailExiste(String email) {
        return _userRepository.existsByEmail(email);
    }

    public boolean telefoneExiste(String telefone) {
        return _userRepository.existsByTelefone(telefone);
    }

    private RoleNome parseRole(String nomeRole) {
        try {
            return RoleNome.valueOf(nomeRole.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Role inválida: " + nomeRole +
                    ". Valores válidos: ADMIN, TURISTA, OPERADOR, GUIA, HOTEL, RESTAURANTE, TRANSPORTADORA, SUPORTE");
        }
    }
}