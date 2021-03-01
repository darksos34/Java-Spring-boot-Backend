package com.FullStack.role.service;

import com.FullStack.role.model.ERole;
import com.FullStack.role.model.Role;
import com.FullStack.role.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor // Lombok to create the Required Args Constructor
@Service // Instruct Spring Boot that this is the Service layer
public class RoleService {

    // Import Methods from other Class
    private final RoleRepository roleRepository; // Class from which methods are being imported

    // Get role by name
    public Optional<Role> getRoleByName(ERole name) { // Generate function
        return roleRepository.getRoleByName(name); // Call JPA function via the Repository
    }

}
