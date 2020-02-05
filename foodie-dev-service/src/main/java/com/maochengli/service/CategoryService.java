package com.maochengli.service;

import com.maochengli.pojo.Category;
import com.maochengli.vo.CategoryItemVo;
import com.maochengli.vo.CategoryVo;

import java.util.List;

public interface CategoryService {
    /**
     * 查询所有根分类
     * @return
     */
    List<Category> queryAllRootLevCategory();

    /**
     * 根据Id查询根分类下的子级分类
     */
    List<CategoryVo> querySubListByRootCatId(Integer rootCatId);


    /**
     * 首页分类推荐商品查询
     */

    List<CategoryItemVo> querySixNewItemLazy(Integer rootCatId);

}
