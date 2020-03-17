package com.guaguauu.service.impl;

import com.guaguauu.dao.UserDao;
import com.guaguauu.dao.impl.UserDaoImpl;
import com.guaguauu.entity.User;
import com.guaguauu.service.UserService;

public class UserServiceImpl implements UserService {
    //多态，后面调用userdao的check方法
    UserDao userDao = new UserDaoImpl();
    @Override
    public User checkUser(User user) {
        return userDao.checkUser(user);
    }
}
