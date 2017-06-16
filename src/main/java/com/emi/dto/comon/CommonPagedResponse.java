package com.emi.dto.comon;

/**
 * Created by emi on 2016/11/1.
 */
public class CommonPagedResponse {

    private Object[] data;

    private PageRespVo pageRespVo;

    public CommonPagedResponse(Object[] data, PageRespVo pageRespVo) {
        this();
        this.data = data;
        this.pageRespVo = pageRespVo;
    }

    public CommonPagedResponse() {

    }

    public Object[] getData() {
        return data;
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public PageRespVo getPageRespVo() {
        return pageRespVo;
    }

    public void setPageRespVo(PageRespVo pageRespVo) {
        this.pageRespVo = pageRespVo;
    }
}
