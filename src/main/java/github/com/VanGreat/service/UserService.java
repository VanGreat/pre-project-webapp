package github.com.VanGreat.service;

import github.com.VanGreat.model.Role;
import github.com.VanGreat.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void createUser(String name, String email, String login, String password);
    void editUser(User user);
    void deleteUser(Long id);
    User getUser(Long id);
    List<User> getAllUsers();
    User getUserByName(String login);
    Role getRoleByName(String name);
}
