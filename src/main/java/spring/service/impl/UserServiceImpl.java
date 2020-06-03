package spring.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import spring.dao.UserDao;
import spring.models.User;
import spring.service.UserService;
import spring.util.HashUtil;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword(user.getPassword(), user.getSalt()));
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
