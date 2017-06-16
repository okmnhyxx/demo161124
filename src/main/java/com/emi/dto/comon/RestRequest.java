package com.emi.dto.comon;

import java.util.Map;

/**
 * Created by emi on 2016/11/3.
 */
public abstract class RestRequest {
    public abstract Map<String,String> fetchParameter();
}
