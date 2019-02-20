package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.thirdpartyjar.SessionManager;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.User;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.UserService;

public abstract class UserAuthenticator implements UserService {

    private SessionManager sessionManager;

    public boolean authenticateUsernameAndPassword(String userName, String password) {
        User user = getUserByName(userName);
        if(user != null) {
            if (isPasswordCorrect(user, password)) {
                sessionManager.setCurrentUser(user);
                return true;
            }
        }
        return false;
    }
}
