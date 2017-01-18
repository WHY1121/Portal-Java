package com.t2cloud.util;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: twcloud1
 * Date: 2017/1/11
 * Time: 11:27
 */
public class UUIDUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
