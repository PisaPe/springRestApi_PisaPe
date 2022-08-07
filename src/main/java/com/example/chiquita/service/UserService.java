package com.example.chiquita.service;

import com.example.chiquita.entities.RoleEntity;
import com.example.chiquita.entities.UserEntity;
import com.example.chiquita.repositories.RoleRepository;
import com.example.chiquita.repositories.UserRepository;
import com.example.chiquita.requests.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.HashSet;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }
    public UserEntity getByEmail(String email){
        return userRepository.findByEmail(email);
    }
    @Transactional
    public UserEntity saveUser(RegisterRequest registerRequest){
        var userEntity = new UserEntity();
//        BeanUtils.copyProperties(registerRequest,userEntity);
        userEntity.setEmail(registerRequest.email());
        userEntity.setActive(true);
        userEntity.setFirstName(registerRequest.firstName());
        userEntity.setLastName(registerRequest.lastName());
        userEntity.setPassword(passwordEncoder.encode(registerRequest.password()));

        var roleEntity = roleRepository.findByRole("USER_BASIC");
        userEntity.setRoles(new HashSet<RoleEntity>(Collections.singletonList(roleEntity)));

        return userRepository.save(userEntity);
    }
}
