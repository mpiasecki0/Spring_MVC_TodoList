package com.example.spring_rest_todo_list.services;

import com.example.spring_rest_todo_list.model.CustomUserDetails;
import com.example.spring_rest_todo_list.model.User;
import com.example.spring_rest_todo_list.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findUserByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // Used by Spring Security
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(name);
        if(user == null){
            throw new UsernameNotFoundException("User has not been found/does not exist! User: "+name);
        }
        return new CustomUserDetails(user);
    }
}
