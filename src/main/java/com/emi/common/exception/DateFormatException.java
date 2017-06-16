package com.emi.common.exception;

import com.emi.common.ErrorCode;
import com.emi.config.SystemConfigs;
import org.slf4j.Logger;

import java.text.SimpleDateFormat;

/**
 * Created by emi on 2016/5/17.
 */
public class DateFormatException extends RestException {
    public DateFormatException(SimpleDateFormat sdf, String dateString,Logger logger) {
        super(ErrorCode.DATE_FORMAT_EXCEPTION, "日期格式错误");
        if (null != logger) {
            logger.error("日期格式错误,需要格式：" + sdf.toPattern() + "实际格式：" + dateString);
        }
    }
}
