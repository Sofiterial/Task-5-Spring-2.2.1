package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");

        Car volvo = new Car("lada", 123);
        Car bmw = new Car("BMW", 325);
        Car suzuki = new Car("uaz", 4);
        Car lada = new Car("volvo", 321);

        userService.add(user1.setCar(volvo).setUser(user1));
        userService.add(user2.setCar(bmw).setUser(user2));
        userService.add(user3.setCar(suzuki).setUser(user3));
        userService.add(user4.setCar(lada).setUser(user4));

        System.out.println(userService.getUserByCar("BMW", 325).toString());



        context.close();
    }
}
