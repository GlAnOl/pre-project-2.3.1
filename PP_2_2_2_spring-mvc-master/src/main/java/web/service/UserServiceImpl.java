package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDaoImp ud;

    public UserServiceImpl() {
    }

    @Transactional
    @Override
    public void addUser(User user) {
        ud.addUser(user);
    }


    @Transactional(readOnly = true)
    @Override
    public List<User> getUsersList() {
        return ud.getUsersList();
    }


 @Override
 @Transactional(readOnly = true)
 public User getUser(int id) {
  return ud.getUser(id);
 }


    @Transactional
    @Override
    public void dropUser(int id) {
        ud.dropUser(id);
    }


    @Transactional
    @Override
    public void changeUser(User user) {
       ud.changeUser(user);
    }
}
