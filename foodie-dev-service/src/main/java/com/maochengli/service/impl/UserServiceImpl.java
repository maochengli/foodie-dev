package com.maochengli.service.impl;

import com.maochengli.bo.UserBO;
import com.maochengli.enums.Sex;
import com.maochengli.mapper.UsersMapper;
import com.maochengli.pojo.Users;
import com.maochengli.service.UserService;
import com.maochengli.utils.DateUtil;
import com.maochengli.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    private static final String USER_FACE = "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";

    /**
     * 查询用户名是否存在
     * @param username 用户名
     * @return false 不存在； true 存在
     */
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean queryUsernameExits(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("username",username);
        Users users = usersMapper.selectOneByExample(userExample);
        return users == null?false:true;
    }

    @Transactional
    @Override
    public Users createUser(UserBO userBo) {
        Users user = new Users();
        user.setUsername(userBo.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBo.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //默认用户姓名和用户名一样
        user.setNickname(userBo.getUsername());

        user.setFace(USER_FACE);

        user.setBirthday(DateUtil.stringToDate("1970-01-01"));

        user.setSex(Sex.secret.sex);

        user.setCreatedTime(new Date());

        user.setUpdatedTime(new Date());

        user.setId(sid.nextShort());

        usersMapper.insert(user);
        return user;
    }

    @Override
    public Users queryUserForLogin(String username, String password) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        criteria.andEqualTo("password",password);
        Users users = usersMapper.selectOneByExample(example);
        return users;
    }



}
