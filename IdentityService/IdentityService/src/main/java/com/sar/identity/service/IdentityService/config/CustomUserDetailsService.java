package com.sar.identity.service.IdentityService.config;

import com.sar.identity.service.IdentityService.entities.UserCredentials;
import com.sar.identity.service.IdentityService.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentials> credentials=userCredentialRepository.findByName(username);
        return credentials.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found with Username:"+username));
    }
}
