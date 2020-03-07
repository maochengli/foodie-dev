package com.maochengli.mapper;

import com.maochengli.vo.ItemCommentVo;
import com.maochengli.vo.SearchItemVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsCustomerMapper {

    /**
     * 查询商品评价
     * @param paramsMap
     * @return
     */
    List<ItemCommentVo> queryItemComments(@Param("paramsMap") Map<String, Object> paramsMap);

    /**
     * 搜索查询商品
     * @param paramsMap
     * @return
     */
    List<SearchItemVo> searchItems(@Param("paramsMap") Map<String, Object> paramsMap);
}
