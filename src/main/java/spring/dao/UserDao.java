package spring.dao;

import java.util.List;
import spring.models.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
