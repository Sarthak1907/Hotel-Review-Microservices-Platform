package com.sar.identity.service.IdentityService.serivce;

import com.sar.identity.service.IdentityService.entities.UserCredentials;
import com.sar.identity.service.IdentityService.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserCredentials credentials){
        credentials.setPassword(passwordEncoder.encode(credentials.getPassword()));
        userCredentialRepository.save(credentials);
        return "User Added to the System!!!";
    }

    public String generateToken(String username){
        return jwtService.generateToken(username);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }

}
