package com.maochengli.vo;

import java.util.List;

/**
 * 首页 商品分类VO
 */
public class CategoryItemVo {

    /**
     * 首页一级分类ID
     */
    private Integer rootCatId;

    /**
     * 一级分类名称
     */
    private String rootCatName;

    /**
     * 一级分类口号
     */
    private String slogan;

    /**
     * 背景色
     */
    private String bgColor;

    /**
     * 首页商品VOList
     */
    private List<IndexItemVo> indexItemVos;

    public List<IndexItemVo> getIndexItemVos() {
        return indexItemVos;
    }

    public void setIndexItemVos(List<IndexItemVo> indexItemVos) {
        this.indexItemVos = indexItemVos;
    }

    public Integer getRootCatId() {
        return rootCatId;
    }

    public void setRootCatId(Integer rootCatId) {
        this.rootCatId = rootCatId;
    }

    public String getRootCatName() {
        return rootCatName;
    }

    public void setRootCatName(String rootCatName) {
        this.rootCatName = rootCatName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }
}
