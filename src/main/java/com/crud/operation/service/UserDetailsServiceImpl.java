package com.crud.operation.service;

import com.crud.operation.entity.User;
import com.crud.operation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.UserBuilder;


import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user =
                userRepository.findByUsername(username);

        UserBuilder builder = null;
        if (user.isPresent()){
            User currentUser = user.get();
            builder = org
                    .springframework
                    .security
                    .core
                    .userdetails
                    .User
                    .withUsername(username);
            builder.password(currentUser.getPassword());
            builder.roles(currentUser.getRole());
        }else {
            throw new UsernameNotFoundException("User NOT Found");
        }
        return builder.build();
    }
}
