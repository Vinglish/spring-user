package org.spring.service;

import java.util.List;
import org.spring.models.User;

public interface UserService {

    void add(User user);

    List<User> listUsers();

    User get(Long userId);
}
