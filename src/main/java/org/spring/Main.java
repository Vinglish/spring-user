package org.spring;

import org.spring.config.AppConfig;
import org.spring.models.User;
import org.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User mark = new User("mark@gmail.com", "1111");
        User nick = new User("nick@gmail.com", "2222");
        userService.add(mark);
        userService.add(nick);
        userService.listUsers().forEach(user -> System.out.println(user.toString()));
    }
}
