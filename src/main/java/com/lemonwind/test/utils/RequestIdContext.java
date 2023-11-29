package com.lemonwind.test.utils;

/**
 * 请求 id 上下文
 */
public class RequestIdContext {

    private static ThreadLocal<String> ID_CONTEXT = new ThreadLocal<>();

    public static String get() {
        return ID_CONTEXT.get();
    }

    public static void set(String requestId) {
        ID_CONTEXT.set(requestId);
    }

    public static void remove() {
        ID_CONTEXT.remove();
    }

}
