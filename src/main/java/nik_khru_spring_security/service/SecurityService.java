package nik_khru_spring_security.service;


public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
