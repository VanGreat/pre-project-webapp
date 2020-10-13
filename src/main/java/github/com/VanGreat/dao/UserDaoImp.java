package github.com.VanGreat.dao;

import github.com.VanGreat.model.Role;
import github.com.VanGreat.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createUser(String name, String email, String login, String password) {
        User user = new User(name, email, login, password);
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> listUsers = (List<User>) entityManager.createQuery("from User").getResultList();
        return listUsers;
    }

    @Override
    public User getUserByName(String login) {
        return entityManager.find(User.class, login);
    }

    @Override
    public Role getRoleByName(String name) {
        return entityManager.find(Role.class, name);
    }
}
