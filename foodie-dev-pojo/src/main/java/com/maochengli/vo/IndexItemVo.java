package com.maochengli.vo;

import java.util.Date;

/**
 * 首页推荐商品Vo
 */
public class IndexItemVo {
    /**
     * ID
     */
    private String itemId;

    /** 商品名 */

    private String itemName;

    /**
     * 主图地址
     */
    private String itemUrl;


    /**
     * 商品创建时间
     */
    private Date createTime;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
