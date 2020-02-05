package com.maochengli.service.impl;

import com.maochengli.mapper.CategoryMapper;
import com.maochengli.pojo.Category;
import com.maochengli.service.CategoryService;
import com.maochengli.vo.CategoryItemVo;
import com.maochengli.vo.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<Category> queryAllRootLevCategory() {
        Example example =  new Example(Category.class);Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type",1);
        List<Category> categories = categoryMapper.selectByExample(example);
        return categories;
    }

    @Override
    public List<CategoryVo> querySubListByRootCatId(Integer rootCatId) {
        return categoryMapper.getSubCatList(rootCatId);
    }

    @Override
    public List<CategoryItemVo> querySixNewItemLazy(Integer rootCatId) {
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("rootCatId",rootCatId);
        return categoryMapper.getSixNewItemLazy(paramMap);
    }


}
