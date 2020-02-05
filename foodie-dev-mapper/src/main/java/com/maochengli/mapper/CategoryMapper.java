package com.maochengli.mapper;

import com.maochengli.base.MyMapper;
import com.maochengli.pojo.Category;
import com.maochengli.vo.CategoryItemVo;
import com.maochengli.vo.CategoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapper extends MyMapper<Category> {

    List<CategoryVo> getSubCatList(Integer rootCatId);

    List<CategoryItemVo> getSixNewItemLazy(@Param("paramMap") Map<String,Object> paramMap);


}