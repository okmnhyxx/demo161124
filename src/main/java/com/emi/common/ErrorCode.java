package com.emi.common;

/**
 * Created by emi on 2016/5/10.
 */
public interface ErrorCode {

    int CODE_400 = 900400;
    int CODE_404 = 900404;
    int CODE_405 = 900405;
    int CODE_500 = 900500;
    int USER_PERMISSION_DENIED = 900401;
    int COMMON_ERROR = 900000;

    int REST_HTTP = 100001;//远程请求
    int DATE_FORMAT_EXCEPTION = 100002;//日期格式化出错


}
