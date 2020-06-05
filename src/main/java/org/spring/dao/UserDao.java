package org.spring.dao;

import java.util.List;
import org.spring.models.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User get(Long userId);
}
