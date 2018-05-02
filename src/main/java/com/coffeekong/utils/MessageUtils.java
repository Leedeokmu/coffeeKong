package com.coffeekong.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageUtils {

    private static MessageSource messageSource;

    public MessageUtils(MessageSource messageSource){ MessageUtils.messageSource = messageSource; }

    public static String getMessage(String key){
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }
    public static String getMessage(String key, Object... args){
        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }
    public static String getMessage(String key, List<Object> args){
        return messageSource.getMessage(key, args.toArray(), LocaleContextHolder.getLocale());
    }

}



