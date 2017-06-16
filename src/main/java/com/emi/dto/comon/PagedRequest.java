package com.emi.dto.comon;

/**
 * Created by emi on 2016/11/3.
 */
public abstract class PagedRequest extends RestRequest {

    private int pageSize;

    private int currentPage;

    public PagedRequest() {
    }

    public PagedRequest(int pageSize, int currentPage) {
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
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
