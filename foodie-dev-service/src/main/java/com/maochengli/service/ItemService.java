package com.maochengli.service;

import com.maochengli.pojo.Items;
import com.maochengli.pojo.ItemsImg;
import com.maochengli.pojo.ItemsParam;
import com.maochengli.pojo.ItemsSpec;
import com.maochengli.utils.PagedGridResult;
import com.maochengli.vo.CommentLevelCountsVo;
import com.maochengli.vo.ItemCommentVo;

import java.util.List;

public interface ItemService {
    /**
     * 根据商品ID查询商品
     * @param itemId
     * @return
     */
    public Items queryItemById(String itemId);


    /**
     * 根据商品id查询商品图片列表
     * @param itemId
     * @return
     */
    public List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品id查询商品规格
     * @param itemId
     * @return
     */
    public List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 查询商品参数
     * @param itemId
     * @return
     */
    public ItemsParam queryItemsParam(String itemId);


    /**
     * 查询评价等级个数
     */
    public CommentLevelCountsVo queryCommentCounts(String itemId);

    public PagedGridResult queryItemComments(String itemId, Integer level, Integer page, Integer pageSize);

}
