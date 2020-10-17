package github.com.VanGreat.dao;

import github.com.VanGreat.model.Role;
import github.com.VanGreat.model.User;

import java.util.List;

public interface UserDao {
    void createUser(String name, String surname, String login, String password, Boolean role);
    void editUser(User user);
    void deleteUser(Long id);
    User getUser(Long id);
    List<User> getAllUsers();
    User getUserByLogin(String login);
    Role getRoleByName(String name);
}
