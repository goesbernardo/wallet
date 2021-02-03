package br.com.wallet.service;

import br.com.wallet.model.User;

import java.util.Optional;

public interface UserService {

    User save(User usuario);

    Optional<User> findByEmail(String email);

}
