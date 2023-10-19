package peaksoft.service;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJdbcImpl userService = new UserDaoJdbcImpl();

    public void createUsersTable() {
        userService.createUsersTable();
    }

    public void dropUsersTable() {
        userService.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userService.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userService.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public void cleanUsersTable() {
        userService.cleanUsersTable();
    }
}
