package br.com.wallet.service.impl;

import br.com.wallet.model.User;
import br.com.wallet.repository.UserRepository;
import br.com.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User usuario) {
        return userRepository.save(usuario);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmailEquals(email);
    }
}
