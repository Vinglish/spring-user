package spring.service;

import java.util.List;
import spring.models.User;

public interface UserService {

    void add(User user);

    List<User> listUsers();
}
