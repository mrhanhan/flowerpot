package com.flowerpot.common.utils.message;

import lombok.experimental.UtilityClass;
import org.springframework.context.MessageSource;

/**
 * MessageUtil
 *
 * @author Mrhan
 * @date 2021/6/27 19:39
 */
@UtilityClass
public class MessageUtil {

    private MessageSource messageSource;

    private MessageSource getMessageSource() {
        if (messageSource == null) {

        }
        return messageSource;
    }
}
