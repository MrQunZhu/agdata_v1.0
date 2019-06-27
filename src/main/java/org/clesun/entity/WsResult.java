package org.clesun.entity;

import org.clesun.utils.Constant;

/**
 * Created by clesun on 2017/5/17.
 */
public class WsResult {
    private String status;// 状态值：success:成功;failed:失败
    private String msg="";// 失败的提示信息
    private Object datas=null;


    public Object getDatas() {
        return datas;
    }

    public void setDatas(Object datas) {
        this.datas = datas;
    }

    public WsResult() {
        status = Constant.Status.SUCCESS;

    }

    public WsResult(String status) {
        this.status = status;
    }

    public WsResult(String status, String errmsg) {
        this.status = status;
        this.msg = errmsg;
    }

    public WsResult(String status, String errmsg,Object datas) {
        this.status = status;
        this.msg = errmsg;
        this.datas = datas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return null == msg ? "" : msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{\"status\":\""+status+"\",\"msg\":\""+msg+"\"}";
    }

}
