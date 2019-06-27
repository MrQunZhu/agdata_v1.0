package org.clesun.utils;

/**
 * Created by clesun on 2017/5/17.
 */

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * 字符串编码转换
 * @ClassName: StringEncode
 * @Description:

 *
 */
public class StringEncode {
    /**
     * iso8859-1转化为utf-8编码
     *
     * @param str
     * @return
     */
    public static String iso2utf(String str) {
        String result = StringUtils.stripToEmpty(str);
        if("".equals(result)) {
            return result;
        }
        try {
            if("ISO-8859-1".equals(getEncoding(result))) {
                result = new String(result.getBytes("ISO-8859-1"), "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 判断字符串的编码
     * @param str
     * @return
     */
    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(getEncoding("aaaa"));
        System.out.println(getEncoding("三四"));
    }
}
