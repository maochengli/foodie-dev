package com.maochengli.service.base;

import com.github.pagehelper.PageInfo;
import com.maochengli.utils.PagedGridResult;

import java.util.List;

public class BaseService {

    /**
     * 创建分页返回实体
     * @param list  数据list
     * @param page  当前页
     * @return
     */
    public PagedGridResult setPageGrid(List<?> list, int page){
        PageInfo<?> pageInfo = new PageInfo<>(list);
        PagedGridResult pagedGrid = new PagedGridResult();
        pagedGrid.setPage(page);
        pagedGrid.setRows(list);
        pagedGrid.setRecords(pageInfo.getTotal());
        pagedGrid.setTotal(pageInfo.getPages());
        return pagedGrid;
    }
}
