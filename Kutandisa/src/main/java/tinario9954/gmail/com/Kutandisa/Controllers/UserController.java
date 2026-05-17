package tinario9954.gmail.com.Kutandisa.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import tinario9954.gmail.com.Kutandisa.DTOS.auth.AuthResponseDTO;
import tinario9954.gmail.com.Kutandisa.DTOS.auth.LoginRequestDTO;
import tinario9954.gmail.com.Kutandisa.DTOS.auth.RegisterRequestDTO;
import tinario9954.gmail.com.Kutandisa.Model.User;
import tinario9954.gmail.com.Kutandisa.Service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
 
    @Autowired
    private UserService userService;
 
    // ─────────────────────────────────────────────
    //  AUTH (públicas)
    // ─────────────────────────────────────────────
 
    @PostMapping("/registar")
    public ResponseEntity<?> registar(@RequestBody RegisterRequestDTO dto) {
        try {
            AuthResponseDTO response = userService.registar(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
 
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto) {
        try {
            AuthResponseDTO response = userService.login(dto);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
 
    // ─────────────────────────────────────────────
    //  LEITURA (protegidas)
    // ─────────────────────────────────────────────
 
    @GetMapping
    public ResponseEntity<List<User>> listarTodos() {
        return ResponseEntity.ok(userService.listarTodos());
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.buscarPorId(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
 
    @GetMapping("/email/{email}")
    public ResponseEntity<?> buscarPorEmail(@PathVariable String email) {
        return userService.buscarPorEmail(email)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utilizador não encontrado."));
    }
 
    @GetMapping("/telefone/{telefone}")
    public ResponseEntity<?> buscarPorTelefone(@PathVariable String telefone) {
        return userService.buscarPorTelefone(telefone)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Utilizador não encontrado."));
    }
 
    @GetMapping("/buscar")
    public ResponseEntity<List<User>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(userService.buscarPorNome(nome));
    }
 
    @GetMapping("/role/{nomeRole}")
    public ResponseEntity<List<User>> listarPorRole(@PathVariable String nomeRole) {
        return ResponseEntity.ok(userService.listarPorRole(nomeRole));
    }
 
    @GetMapping("/role/{nomeRole}/activos")
    public ResponseEntity<List<User>> listarActivosPorRole(@PathVariable String nomeRole) {
        return ResponseEntity.ok(userService.listarActivosPorRole(nomeRole));
    }
 
    @GetMapping("/role/{nomeRole}/total")
    public ResponseEntity<Long> contarPorRole(@PathVariable String nomeRole) {
        return ResponseEntity.ok(userService.contarPorRole(nomeRole));
    }
 
    @GetMapping("/activos")
    public ResponseEntity<List<User>> listarActivos() {
        return ResponseEntity.ok(userService.listarActivos());
    }
 
    @GetMapping("/inactivos")
    public ResponseEntity<List<User>> listarInactivos() {
        return ResponseEntity.ok(userService.listarInactivos());
    }
 
    // ─────────────────────────────────────────────
    //  ACTUALIZAÇÃO (protegidas)
    // ─────────────────────────────────────────────
 
    @PutMapping("/{id}/perfil")
    public ResponseEntity<?> actualizarPerfil(
            @PathVariable Long id,
            @RequestParam(required = false) String nomeCompleto,
            @RequestParam(required = false) String telefone,
            @RequestParam(required = false) String fotoPerfil) {
        try {
            return ResponseEntity.ok(userService.actualizarPerfil(id, nomeCompleto, telefone, fotoPerfil));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
 
    @PutMapping("/{id}/password")
    public ResponseEntity<?> alterarPassword(
            @PathVariable Long id,
            @RequestParam String passwordActual,
            @RequestParam String novaPassword) {
        try {
            userService.alterarPassword(id, passwordActual, novaPassword);
            return ResponseEntity.ok("Password alterada com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
 
    @PutMapping("/{id}/role")
    public ResponseEntity<?> alterarRole(
            @PathVariable Long id,
            @RequestParam String nomeRole) {
        try {
            return ResponseEntity.ok(userService.alterarRole(id, nomeRole));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
 
    // ─────────────────────────────────────────────
    //  ACTIVAÇÃO / DESACTIVAÇÃO (só ADMIN)
    // ─────────────────────────────────────────────
 
    @PutMapping("/{id}/activar")
    public ResponseEntity<?> activar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.activar(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
 
    @PutMapping("/{id}/desactivar")
    public ResponseEntity<?> desactivar(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.desactivar(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
 
    // ─────────────────────────────────────────────
    //  ELIMINAÇÃO (só ADMIN)
    // ─────────────────────────────────────────────
 
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            userService.eliminar(id);
            return ResponseEntity.ok("Utilizador eliminado com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}