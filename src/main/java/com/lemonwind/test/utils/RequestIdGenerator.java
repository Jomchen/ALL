package com.lemonwind.test.utils;

import java.util.UUID;

/**
 * create by lemonwind on 12/30/18
 */
public class RequestIdGenerator {

    public static String generate() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return String.format(CommonBussiness.REQUESTID_DEMO, uuid);
    }

}
