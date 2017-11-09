package nik_khru_spring_security.service;

import nik_khru_spring_security.model.User;
import nik_khru_spring_security.model.User;


public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
