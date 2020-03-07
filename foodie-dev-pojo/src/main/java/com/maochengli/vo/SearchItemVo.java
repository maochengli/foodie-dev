package com.maochengli.vo;

/**
 * 搜索查询VO
 */
public class SearchItemVo {
    /**
     * id
     */
    private  String itemId;

    /**
     * 商品名
     */
    private String itemName;

    /**
     * 销售量
     */
    private int  sellCounts;

    /**
     * 商品图片
     */
    private String imgUrl;

    /**
     * 价格
     */
    private int price;

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

    public int getSellCounts() {
        return sellCounts;
    }

    public void setSellCounts(int sellCounts) {
        this.sellCounts = sellCounts;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
