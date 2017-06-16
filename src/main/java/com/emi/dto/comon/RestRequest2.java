package com.emi.dto.comon;

import com.emi.common.exception.CommonException;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by emi on 2016/11/2.
 */
public abstract class RestRequest2<T extends RestResponse> {

    public abstract Map<String,String> fetchParameter();

    public Class<T> fetchResponseClass() {
        try {
            Type genType = getClass().getGenericSuperclass();
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            Class<T> entityClass = (Class<T>) params[0];
            return (Class<T>) entityClass.newInstance().getClass();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonException("请求类写法不符合标准", "需要声明响应类", e, LoggerFactory.getLogger(this.getClass()));
        }
    }
}
