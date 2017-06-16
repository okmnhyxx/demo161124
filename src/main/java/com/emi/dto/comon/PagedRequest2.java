package com.emi.dto.comon;


/**
 * Created by emi on 2016/11/1.
 */
public abstract class PagedRequest2<T extends RestResponse> extends RestRequest2<T> {

    private int pageSize;

    private int currentPage;

    public PagedRequest2() {
    }

    public PagedRequest2(int pageSize, int currentPage) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return 0 == pageSize ? 10 : pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return 0 == currentPage ? 1 : currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
