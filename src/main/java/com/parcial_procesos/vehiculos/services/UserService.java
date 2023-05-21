package com.parcial_procesos.vehiculos.services;

import com.parcial_procesos.vehiculos.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User getUser(Long id);
    Boolean createUser(User user);
    List<User> allUsers();
    Boolean updateUser(Long id, User user);
    String login(User user);
}
