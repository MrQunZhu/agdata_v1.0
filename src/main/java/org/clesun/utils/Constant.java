package org.clesun.utils;

/**
 * Created by clesun on 2017/4/27.
 */
public class Constant {

    /**
     * 状态变量
     */
    public static class Status {
        public final static String SUCCESS = "success";
        public final static String FAILED = "failed";

    }

    public static final int SUPER_ADMIN = 1;

    /**
     * 登录类型
     */
    public enum LoginType {
        /**
         * 用户名密码登录
         */
        USERNAMEPASSWORD(0),
        /**
         * 手机号密码登录
         */
        PHONENUMPASSWORD(1);


        private int value;

        LoginType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
