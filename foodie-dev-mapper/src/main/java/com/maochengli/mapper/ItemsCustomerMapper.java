package com.maochengli.mapper;

import com.maochengli.vo.ItemCommentVo;
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

}
