package com.study.box.server.utils;

import com.study.box.server.models.entity.Role;
import com.study.box.server.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DatabaseInitializer implements CommandLineRunner {
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        List<String> roles = List.of("USER", "ADMIN", "INSTRUCTOR");
        roles.forEach(role -> roleRepository.save(Role.builder()
                .name(role)
                .build()));
    }
}
