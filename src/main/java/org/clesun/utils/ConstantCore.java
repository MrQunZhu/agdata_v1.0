package org.clesun.utils;

/**
 * Created by clesun on 2017/5/17.
 */
public class ConstantCore {

    public static final String CONFIG_PROPS="conf.properties";
    public static final String PLUGIN_PACKAGE = ConfigUtils.getString("class-scan-plugin-package","");//"cn.gcks.plugin";
    public static final String BASE_PACKAGE = ConfigUtils.getString("class-scan-base-package","");


    /**
     * 图像验证码的长度
     */
    public static final int RandStrLen=4;
    /**
     * 图像验证码在session中提取的KEY
     */
    public static String SESSION_RandStr="Cn-gcks-Rand";

    public static String SESSION_CLIENT_TYPE="Client-Type";
    public static String SESSION_USER_ID="SESSION_USER_ID";
    public static String SESSION_USER_TOKEN="SESSION_USER_TOKEN";
    public static String SESSION_USER_NAME="SESSION_USER_NAME";
    public static String SESSION_USER_OBJ="SESSION_USER_OBJ";
    public static String SESSION_USER_POWER_LIST="SESSION_USER_POWER_LIST";
    public static String SESSION_USER_ORGID = "SESSION_USER_ORGID";

    /**
     * 没有登录
     */
    public static String MSG_NO_LOGIN="MSG_NO_LOGIN";//没有登录
    /**
     * 权限资源不存在
     */
    public static String MSG_NO_POWER="MSG_NO_POWER";//权限资源不存在
    /**
     * 权限资源为禁用
     */
    public static String MSG_APP_DISABLE="MSG_APP_DISABLE";//权限资源为禁用
    /**
     * 用户没有此权限
     */
    public static String MSG_FORBIDDEN="MSG_FORBIDDEN";//用户没有此权限

    public static String Common_PageInfo_PageSize="Common_PageInfo_PageSize";
    //	public static String Class_Scan_Base_Package="Class_Scan_Base_Package";


}
