package com.emi.common.exception;

import com.emi.common.ErrorCode;
import com.emi.config.SystemConfigs;
import com.emi.config.SystemProperties;
import org.slf4j.Logger;
import org.springframework.util.StringUtils;

/**
 * Created by emi on 2016/10/31.
 */
public class CommonException extends RestException {

    public CommonException(String message, String detailMessage, Exception e, Logger logger) {
        super(ErrorCode.COMMON_ERROR, message);
        if (null != logger) {
            logger.error(StringUtils.isEmpty(detailMessage) ? message: detailMessage);
        }
    }

}
