package com.maochengli.service.impl;

import com.github.pagehelper.PageHelper;
import com.maochengli.enums.CommentLevelEnum;
import com.maochengli.mapper.*;
import com.maochengli.pojo.*;
import com.maochengli.service.ItemService;
import com.maochengli.service.base.BaseService;
import com.maochengli.utils.PagedGridResult;
import com.maochengli.vo.CommentLevelCountsVo;
import com.maochengli.vo.ItemCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl extends BaseService implements ItemService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Autowired
    private ItemsImgMapper itemsImgMapper;

    @Autowired
    private ItemsSpecMapper itemsSpecMapper;

    @Autowired
    private ItemsParamMapper itemsParamMapper;

    @Autowired
    private ItemsCommentsMapper itemsCommentsMapper;

    @Autowired
    private ItemsCustomerMapper itemsCustomerMapper;

    @Override
    public Items queryItemById(String itemId) {
        return itemsMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public List<ItemsImg> queryItemImgList(String itemId) {
        Example example = new Example(ItemsImg.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsImgMapper.selectByExample(example);
    }

    @Override
    public List<ItemsSpec> queryItemSpecList(String itemId) {
        Example example = new Example(ItemsSpec.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsSpecMapper.selectByExample(example);
    }

    @Override
    public ItemsParam queryItemsParam(String itemId) {
        Example example = new Example(ItemsParam.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId",itemId);
        return itemsParamMapper.selectOneByExample(example);
    }

    @Override
    public CommentLevelCountsVo queryCommentCounts(String itemId) {
        Integer goodCounts = getCommentCounts(itemId, CommentLevelEnum.GOOD.type);
        Integer normalCounts = getCommentCounts(itemId, CommentLevelEnum.NORMAL.type);
        Integer badCounts = getCommentCounts(itemId, CommentLevelEnum.BAD.type);
        int totalCounts = goodCounts + normalCounts + badCounts;
        CommentLevelCountsVo commentLevelCountsVo = new CommentLevelCountsVo();
        commentLevelCountsVo.setTotalCounts(totalCounts);
        commentLevelCountsVo.setGoodCounts(goodCounts);
        commentLevelCountsVo.setNormalCounts(normalCounts);
        commentLevelCountsVo.setBadCounts(badCounts);
        return commentLevelCountsVo;
    }

    /**
     * 查询评价登记个数
     * @param itemId 商品Id
     * @param level 评价登记 
     * @return  该评价登记个数
     */
    public Integer getCommentCounts(String itemId, Integer level){
        ItemsComments itemsComments = new ItemsComments();
        if(level != null){
            itemsComments.setCommentLevel(level);
        }
        itemsComments.setItemId(itemId);
        return itemsCommentsMapper.selectCount(itemsComments);        
    }


    @Override
    public PagedGridResult queryItemComments(String itemId, Integer level, Integer page, Integer pageSize) {
        Map<String,Object>  paramsMap = new HashMap<>();
        paramsMap.put("itemId",itemId);

        if(level != null){
            paramsMap.put("level",level);
        }
        PageHelper.startPage(page,pageSize);
        List<ItemCommentVo> list = itemsCustomerMapper.queryItemComments(paramsMap);
        return setPageGrid(list,page);
    }
}
