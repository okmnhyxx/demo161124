package com.emi.common.util;

import com.emi.common.exception.CommonException;
import com.emi.common.exception.RestExecuteException;
import com.emi.dto.comon.RestRequest2;
import com.emi.dto.comon.RestResponse;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by emi on 2016/10/31.
 */
@Component
public class OkHttpUtils2 {

    OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();
    String charset = "UTF-8";
    Logger logger = LoggerFactory.getLogger(this.getClass());


//    public <T extends RestResponse> T get(String url, RestRequest2 restRequest, Class<T> responseClass) {
    public <T extends RestResponse> T get(String url, RestRequest2<T> restRequest) {
        String urlParam = null == restRequest ? "" : null == restRequest.fetchParameter() ? this.reflectUrl(restRequest) : this.buildUrl(restRequest.fetchParameter());
        Request request = new Request.Builder().url(url + urlParam)
                .get()
                .build();
        assert restRequest != null;
        return this.fetchCallResponse(url, request, restRequest.fetchResponseClass());
    }

    public <T extends RestResponse> T postJson(String url, RestRequest2<T> restRequest) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson.toJson(restRequest));
        Request request = new Request.Builder().url(url)
                .post(requestBody)
                .build();
        return this.fetchCallResponse(url, request, restRequest.fetchResponseClass());
    }

    public <T extends RestResponse> T post(String url, RestRequest2<T> restRequest) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        builder = null == restRequest ? builder : null == restRequest.fetchParameter() ? this.reflectParam(builder, restRequest) : this.buildParam(builder, restRequest.fetchParameter());
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder().url(url)
                .post(requestBody)
                .build();
        assert restRequest != null;
        return this.fetchCallResponse(url, request, restRequest.fetchResponseClass());
    }


    private String buildUrl(Map<String, String> params) {
        if(params != null && !params.isEmpty()) {
            String paramsStr;
            StringBuilder paramsBuf = new StringBuilder("?");
            Set<Map.Entry<String, String>> entries = params.entrySet();
            Iterator<Map.Entry<String, String>> var6 = entries.iterator();

            try {
                while(var6.hasNext()) {
                    Map.Entry<String, String> entry = var6.next();
                    String name = entry.getKey();
                    String value = entry.getValue();
                    if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(value)) {
                        paramsBuf.append(name).append("=").append(URLEncoder.encode(value, charset)).append("&");
                    }
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                throw new CommonException("编码异常", "传入数据不支持" + charset + "编码格式", e, logger);
            }
            paramsStr = paramsBuf.toString();
            return paramsStr.substring(0, paramsStr.length() - 1);
        } else {
            return null;
        }
    }

    private FormBody.Builder buildParam(FormBody.Builder builder, Map<String, String> params) {
        Iterator<Map.Entry<String, String>> var3 = params.entrySet().iterator();
        while(var3.hasNext()) {
            Map.Entry<String, String> entry = var3.next();
            String name = entry.getKey();
            String value = entry.getValue();
            if(!StringUtils.isEmpty(name) && !StringUtils.isEmpty(value)) {
                builder.add(name, value);
            }
        }
        return builder;
    }


    /**
     * 利用反射机制（不推荐！） 将 request 里的属性和值 使用?key=value&key2=value2方式连接起来
     * @param restRequest
     * @return
     */
    @Deprecated
    private String reflectUrl(RestRequest2 restRequest) {

        StringBuffer urlParamsBuf = new StringBuffer("?");
        Field[] fields = restRequest.getClass().getDeclaredFields();
        Object value;
        String fieldName;
        String getMethodName;
        Class requestClass = restRequest.getClass();
        try {
            for (Field f : fields) {
                fieldName = f.getName();
                getMethodName = "get"  + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                value = requestClass.getMethod(getMethodName, new Class[]{}).invoke(restRequest, new Class[]{});
                if (!StringUtils.isEmpty(value)) {
                    urlParamsBuf.append(f.getName()).append("=").append(value).append("&");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonException("DTO反射机制获取属性及属性值异常", null, e, logger);
        }
        String urlParams = urlParamsBuf.toString();
        return urlParams.substring(0, urlParams.length() - 1);
    }

    /**
     * 利用反射机制（不推荐！） 将 request 里的属性和值添加到 builder 中， 例如builder.add("userName", "emi")
     * @param builder
     * @param restRequest
     * @return
     */
    @Deprecated
    private FormBody.Builder reflectParam(FormBody.Builder builder, Object restRequest) {
        Field[] fields = restRequest.getClass().getDeclaredFields();
        Object value;
        String fieldName;
        String getMethodName;
        Class requestClass = restRequest.getClass();
        try {
            for (Field f : fields) {
                fieldName = f.getName();
                getMethodName = "get"  + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                value = requestClass.getMethod(getMethodName, new Class[]{}).invoke(restRequest, new Class[]{});

                builder.add(f.getName(), null == value ? "" : String.valueOf(value));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonException("DTO反射机制获取属性及属性值异常", null, e, logger);
        }
        return builder;
    }






    /**
     * 根据requestDTO和url，获取responseDTO，
     * @param url
     * @param request
     * @param responseClass
     * @param <T>
     * @return
     */
    private <T extends RestResponse> T fetchCallResponse(String url, Request request,  Class<T> responseClass) {
        try {
            Response response = client.newCall(request).execute();//核心调用
            if (response.isSuccessful()) {
                String jsonStr = response.body().source().readString(Charset.forName("UTF-8"));
                try {
                    return gson.fromJson(jsonStr, responseClass);
                } catch (JsonSyntaxException e) {
                    throw new CommonException("json转换失败", "json: " + jsonStr + ", class: " + response.getClass().getSimpleName(), e, logger);
                }
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            throw new RestExecuteException("请求失败", "url: " + url, e, logger);
        }

//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                logger.error("", e.getCause());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                logger.info(response.body().toString());
//            }
//        });
    }

}
