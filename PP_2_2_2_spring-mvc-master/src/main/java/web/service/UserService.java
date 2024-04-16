package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getUsersList();

    User getUser(int id);

    void dropUser(int id);

    void changeUser(User user);
}
