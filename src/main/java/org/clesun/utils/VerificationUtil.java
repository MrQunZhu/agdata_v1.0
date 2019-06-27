package org.clesun.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by clesun on 2017/11/22.
 */
public class VerificationUtil {
    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String MOBILE_REGEX = "^[1][3,4,5,7,8][0-9]{9}$";
    private static final String POSTCODE_REGEX = "[1-9]\\d{5}(?!\\d)";
    private static final String TELEPHONE_REGEX = "/^((0\\d{2,3})-)(\\d{7,8})(-(\\d{3,}))?$/";
    /**
     * 手机号验证
     * @author lxq
     * @DATE 2017/11/22
     * @param mobile
     * @return 验证通过返回true
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(MOBILE_REGEX, mobile.trim());
    }

    /**
     * 邮箱验证
     * @author lxq
     * @DATE 2017/11/22
     * @param email
     * @return 验证通过返回true
     */
    public static boolean  isEmail(String email){
        return Pattern.matches(EMAIL_REGEX, email.trim());
    }

    /**
     * @author lxq
     * @DATE 2017/11/22
     * 匹配中国邮政编码
     * @param postCode 邮政编码
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean isPostCode(String postCode){
        return Pattern.matches(POSTCODE_REGEX, postCode.trim());
    }

    /**
     * 固定电话验证
     * @author lxq
     * @DATE 2017/12/14
     * @param telePhoneNo
     * @return
     */
    public static boolean isTelePhoneNo(String telePhoneNo){
        return Pattern.matches(TELEPHONE_REGEX, telePhoneNo.trim());
    }

    public static void main(String[] args) {
        System.out.print(VerificationUtil.isTelePhoneNo("010-82319919"));
    }
}
