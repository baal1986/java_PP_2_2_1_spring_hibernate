package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface UserDao {

    void add(User user);

    List<User> listUsers();

    Optional<User> searchUser(String model, int series);
}
