package com.maochengli.service.impl;

import com.maochengli.mapper.StuMapper;
import com.maochengli.pojo.Stu;
import com.maochengli.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    public Stu getStu(int id) {
        return stuMapper.selectByPrimaryKey(id);
    }
}
