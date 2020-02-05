package com.maochengli.controller;

import com.maochengli.pojo.Category;
import com.maochengli.service.CategoryService;
import com.maochengli.utils.Result;
import com.maochengli.vo.CategoryItemVo;
import com.maochengli.vo.CategoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "首页", tags = "首页展示相关接口")
@RestController
@RequestMapping("index")
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有一级分类
     */

    @GetMapping("/cats")
    @ApiOperation(value = "获取商品顶级分类", notes = "获取商品顶级分类", httpMethod = "GET")
    public Result cats() {
        List<Category> categories = categoryService.queryAllRootLevCategory();
        return Result.ok(categories);
    }

    /**
     * 首页获取商品子级分类
     */
    @GetMapping("/subCat/{rootCatId}")
    @ApiOperation(value = "获取商品子级分类", notes = "获取商品子级分类", httpMethod = "GET")
    public Result subCats(@ApiParam(name = "rootCatId", value = "一级分类Id", required = true, example = "2")
                          @PathVariable Integer rootCatId) {

        if (rootCatId == null){
            return Result.errorMsg("父级分类ID不能为空");
        }

        List<CategoryVo> categories = categoryService.querySubListByRootCatId(rootCatId);
        return Result.ok(categories);
    }


    /**
     * 首页查询推荐商品
     */
    @GetMapping("/sixNewItems/{rootCatId}")
    @ApiOperation(value = "首页获取分类下的六条商品", notes = "首页获取分类下的六条商品", httpMethod = "GET")
    public Result SixNewItems(@ApiParam(name = "rootCatId", value = "一级分类Id", required = true, example = "2")
                          @PathVariable Integer rootCatId) {

        if (rootCatId == null){
            return Result.errorMsg("父级分类ID不能为空");
        }
        List<CategoryItemVo> categoryItemVos = categoryService.querySixNewItemLazy(rootCatId);
        return Result.ok(categoryItemVos);
    }



}
