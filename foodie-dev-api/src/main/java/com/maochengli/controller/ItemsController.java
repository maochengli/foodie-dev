package com.maochengli.controller;

import com.maochengli.pojo.Items;
import com.maochengli.pojo.ItemsImg;
import com.maochengli.pojo.ItemsParam;
import com.maochengli.pojo.ItemsSpec;
import com.maochengli.service.ItemService;
import com.maochengli.utils.PagedGridResult;
import com.maochengli.utils.Result;
import com.maochengli.vo.CommentLevelCountsVo;
import com.maochengli.vo.ItemInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("items")
@Api(value = "商品信息接口", tags = "商品详情接口")
public class ItemsController {
    @Autowired
    private ItemService itemService;

    @ApiOperation(value = "查询商品详情",notes = "查询商品详情",httpMethod = "GET")
    @RequestMapping("info/{itemId}")
    public Result getItemInfo(@ApiParam(name = "itemId",value = "商品Id",required = true,example = "bingan-1005")  @PathVariable String itemId){
        if(StringUtils.isBlank(itemId)){
            return Result.errorMsg("商品id为空");
        }
        Items items = itemService.queryItemById(itemId);
        List<ItemsImg> itemsImgs = itemService.queryItemImgList(itemId);
        List<ItemsSpec> itemsSpecs = itemService.queryItemSpecList(itemId);
        ItemsParam itemsParam = itemService.queryItemsParam(itemId);
        ItemInfoVo itemInfoVo = new ItemInfoVo();
        itemInfoVo.setItem(items);
        itemInfoVo.setItemImgList(itemsImgs);
        itemInfoVo.setItemSpecList(itemsSpecs);
        itemInfoVo.setItemParams(itemsParam);
        return Result.ok(itemInfoVo);

    }


    @ApiOperation(value = "查询商品评价等级个数",notes = "查询商品评价等级个数",httpMethod = "GET")
    @RequestMapping("commentLevel")
    public Result commentLevel(@ApiParam(name = "itemId",value = "商品Id",required = true,example = "bingan-1005")  String itemId){
        if(StringUtils.isBlank(itemId)){
            return Result.errorMsg("商品id为空");
        }
        CommentLevelCountsVo commentLevelCountsVo = itemService.queryCommentCounts(itemId);
        return Result.ok(commentLevelCountsVo);

    }


    @ApiOperation(value = "分页查询商品评价",notes = "分页查询表商品评价",httpMethod = "GET")
    @RequestMapping("comments")
    public Result comments(@ApiParam(name = "itemId",value = "商品Id",required = true,example = "bingan-1005")  String itemId,
                           @ApiParam(name = "level",value = "评价级别",required = false,example = "1") Integer level,
                           @ApiParam(name = "page",value = "当前页",required = false,example = "1") Integer page,
                           @ApiParam(name = "pageSize",value = "每页个数",required = false,example = "10") Integer pageSize){
        if(StringUtils.isBlank(itemId)){
            return Result.errorMsg("商品id为空");
        }
        if(page == null){
            page = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }
        PagedGridResult pagedGridResult = itemService.queryItemComments(itemId, level, page, pageSize);
        return Result.ok(pagedGridResult);

    }



    /**
     * 搜索接口 分页搜索
     * @param keywords   关键字
     * @param sort      排序方式
     * @param page      页数
     * @param pageSize  每页个数
     * @return
     */
    @RequestMapping("/search")
    @ApiOperation(value = "商品搜索查询",notes = "搜索分页查询",httpMethod = "GET")
    public Result search(@ApiParam(name = "keywords", value = "关键字",required = true, example = "肉干") String keywords,
                         @ApiParam(name = "sort", value = "排序方式",required = true,example = "k") String sort,
                         @ApiParam(name = "page",   value = "当前页",required = false,example = "1") Integer page,
                         @ApiParam(name = "pageSize",value = "每页个数",required = false,example = "10") Integer pageSize){

        if(StringUtils.isBlank(keywords)){
            return Result.errorMsg("关键字不能为空");
        }
        if(page == null){
            page = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }

        PagedGridResult pagedGridResult = itemService.searchItems(keywords, sort, page, pageSize);
        return Result.ok(pagedGridResult);

    }




    /**
     * 搜索接口 分页搜索
     * @param catId     分类id
     * @param sort      排序方式
     * @param page      页数
     * @param pageSize  每页个数
     * @return
     */
    @RequestMapping("/catItems")
    @ApiOperation(value = "商品搜索查询",notes = "搜索分页查询",httpMethod = "GET")
    public Result searchByCat(@ApiParam(name = "catId", value = "分类Id",required = true, example = "肉干") Integer catId,
                            @ApiParam(name = "sort", value = "排序方式",required = true,example = "k") String sort,
                             @ApiParam(name = "page",   value = "当前页",required = false,example = "1") Integer page,
                            @ApiParam(name = "pageSize",value = "每页个数",required = false,example = "10") Integer pageSize){

        if(catId == null){
            return Result.errorMsg("分类Id不能为空");
        }
        if(page == null){
            page = 1;
        }
        if (pageSize == null){
            pageSize = 10;
        }
        PagedGridResult pagedGridResult = itemService.searchItemsByItemId(catId, sort, page, pageSize);
        return Result.ok(pagedGridResult);
    }
}
