package tinario9954.gmail.com.Kutandisa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import tinario9954.gmail.com.Kutandisa.Enum.RoleNome;
import tinario9954.gmail.com.Kutandisa.Model.Role;
import tinario9954.gmail.com.Kutandisa.Repository.RoleRepository;

@Component
public class DataInitializer implements CommandLineRunner {
 
    @Autowired
    private RoleRepository roleRepository;
 
    @Override
    public void run(String... args) {
        for (RoleNome roleNome : RoleNome.values()) {
            if (!roleRepository.existsByNome(roleNome)) {
                Role role = new Role();
                role.setNome(roleNome);
                roleRepository.save(role);
                System.out.println("✅ Role criada: " + roleNome);
            }
        }
    }
}