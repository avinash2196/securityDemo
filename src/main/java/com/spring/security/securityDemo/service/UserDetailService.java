package com.spring.security.securityDemo.service;


import com.spring.security.securityDemo.dto.UserModel;
import com.spring.security.securityDemo.model.User;
import com.spring.security.securityDemo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opt = userRepository.findUserByEmail(username);

        if (opt.isEmpty())
            throw new UsernameNotFoundException("User with user name: " + username + " not found !");
        else {
            User user = opt.get();
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    user.getRoles()
                            .stream()
                            .map(role -> new SimpleGrantedAuthority(role))
                            .collect(Collectors.toSet())
            );
        }

    }

    public String saveUser(UserModel userModel) {
        String encodedPassword = passwordEncoder.encode(userModel.getPassword());
        User user = User.builder().firstName(userModel.getFirstName()).lastName(userModel.getLastName())
                .password(encodedPassword).email(userModel.getEmail()).roles(userModel.getRoles()).build();
        user = userRepository.save(user);
        return user.getUserId();
    }
}
