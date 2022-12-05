package org.example;

import org.example.configuration.Config;
import org.example.exeption.MyException;
import org.example.model.Address;
import org.example.model.User;
import org.example.service.ServiceUser;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) throws MyException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        User user = new User("Miha", "Zarubin", 20, new Address("Bereza", "Lenina", 30));
        User user1 = new User("Alex", "Aleksutkin", 40, null);

        ServiceUser service = context.getBean(ServiceUser.class);
        service.addUser(user);
        service.addUser(user1);

//        User searchedUser = service.getById(1L);
//        System.out.println(searchedUser);
        User user2 = new User( 1L, "YASHA", "parasha", 12);
        service.updateUser(user2);

        List<User> userList = service.getAll();
        userList.forEach(System.out::println);

        service.deleteAll();
    }
}
