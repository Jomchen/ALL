package com.lemonwind.test.utils;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * 微信验证工具
 */
public class WechatUtils {

    /**
     * @param signature 微信反馈校验码
     * @param timestamp 微信反馈时间戮
     * @param nonce 微信反馈随机字符串
     * @param token 自定义的校验 token
     * @return true: 成功 | false: 失败
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce, String token){
        // 字典排序
        String[] arr = {token, timestamp, nonce};
        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        for(String s : arr){
            sb.append(s);
        }
        // 加密并验证
        String temp = getSha1(sb.toString());
        return temp.equals(signature);
    }

    /**
     * SHA1 加密
     * @param str 预加密字符串
     */
    public static String getSha1(String str){
        if(str == null || str.length() == 0) {
            return null;
        }
        char hexDigits[] = {
                '0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f'
        };
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));
            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j*2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }
}
