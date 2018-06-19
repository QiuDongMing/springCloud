package com.coderme.commons.base.utils;

import java.util.List;

/**
 * @author qiudm
 * @date 2018/6/19 17:36
 * @desc
 */
public class PageVO<T> {

    /**
     * 从1开始
     */
    private int pageIndex;

    private int pageSize = 10;

    private int total;

    private List<T> data;

    private int pageTotal;

    public PageVO() {

    }


    public PageVO(int pageIndex, int pageSize, int total, List<T> data) {

        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.total = total;
        this.data = data;
    }





    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageTotal() {
        return pageTotal = (total + pageSize - 1) / pageSize ;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }


    public static void main(String[] args) {

        PageVO pageVO = new PageVO();
        pageVO.setPageSize(3);
        pageVO.setTotal(5);
        System.out.println("pageVO.getPageTotal = " + pageVO.getPageTotal());

    }


}
