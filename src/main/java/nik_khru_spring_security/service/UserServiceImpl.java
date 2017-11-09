package nik_khru_spring_security.service;

import nik_khru_spring_security.dao.RoleDao;
import nik_khru_spring_security.dao.UserDao;
import nik_khru_spring_security.model.Role;
import nik_khru_spring_security.model.User;
import nik_khru_spring_security.dao.RoleDao;
import nik_khru_spring_security.dao.UserDao;
import nik_khru_spring_security.model.Role;
import nik_khru_spring_security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
