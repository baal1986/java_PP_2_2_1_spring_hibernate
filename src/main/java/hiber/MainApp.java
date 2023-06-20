package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class MainApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            List<User> users = new ArrayList<>(Arrays.asList(
                    new User("User1", "Lastname1", "user1@mail.ru", new Car("BMW", 3)),
                    new User("User2", "Lastname2", "user2@mail.ru", new Car("BMW", 5)),
                    new User("User3", "Lastname3", "user3@mail.ru", new Car("BMW", 6))
            ));

            UserService userService = context.getBean(UserService.class);
            for (User user : users) {
                userService.add(user);
            }

            userService.listUsers().forEach(System.out::println);


            Optional<User> resultSearch = userService.searchUser("BMW", 3);
            System.out.println(resultSearch.isPresent() ? resultSearch.get() : "Not found!");
        }

    }
}
