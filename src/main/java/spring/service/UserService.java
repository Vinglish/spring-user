package spring.service;

import spring.models.User;

import java.util.List;

public interface UserService {

    void add(User user);

    List<User> listUsers();
}
