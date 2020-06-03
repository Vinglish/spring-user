package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.AppConfig;
import spring.models.User;
import spring.service.UserService;

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
