package github.com.VanGreat.service;

import github.com.VanGreat.dao.UserDao;
import github.com.VanGreat.model.Role;
import github.com.VanGreat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void createUser(String name, String email, String login, String password) {
        userDao.createUser(name, email, login, password);
    }

    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserByName(String login) {
        return userDao.getUserByName(login);
    }

    @Override
    public Role getRoleByName(String name) {
        return userDao.getRoleByName(name);
    }
}
