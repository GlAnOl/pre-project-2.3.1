package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.config.AppConfig;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@ComponentScan(value = "web")
public class UserDaoImp implements UserDao{


    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getUsersList() {
        return entityManager.createQuery("select u from User u",User.class ).getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void dropUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void changeUser(User user) {
        entityManager.merge(user);

    }
}
