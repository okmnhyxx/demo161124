package com.emi.dto.comon;


import com.github.pagehelper.PageInfo;

/**
 * Created by emi on 2016/11/1.
 */
public class PageRespVo {

    private int pageSize;

    private int currentPage;

    private long totalRows;

    public PageRespVo() {
    }

    public PageRespVo(int pageSize, int currentPage, long totalRows) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalRows = totalRows;
    }



    public PageRespVo(PageInfo pageInfo) {
        this.pageSize = pageInfo.getSize();
        this.currentPage = pageInfo.getPageNum();
        this.totalRows = pageInfo.getTotal();
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }
}

