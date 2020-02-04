package com.maochengli.service;

import com.maochengli.bo.UserBO;
import com.maochengli.pojo.Users;

public interface UserService {

    public boolean queryUsernameExits(String username);

    public Users createUser(UserBO userBo);

    public Users queryUserForLogin(String username,String password);

}
