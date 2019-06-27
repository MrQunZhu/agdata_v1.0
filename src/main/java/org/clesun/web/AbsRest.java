package org.clesun.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.clesun.entity.WsResult;
import org.clesun.utils.Constant;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by clesun on 2017/5/17.
 */
public class AbsRest<T> extends BaseAction {
    Logger log = Logger.getLogger(this.getClass());
    public static String SESSION_USER_TOKEN="SESSION_USER_TOKEN";
    public static String SESSION_USER_NAME="SESSION_USER_NAME";
    ObjectMapper jsonMapper = new ObjectMapper();

    protected String getCurrPeopleName(HttpServletRequest request) {
        Object obj = getSession(request).getAttribute(SESSION_USER_NAME);
        if (null != obj && obj instanceof String) {
            return (String) obj;
        }
        return "";
    }


    protected boolean isValid(WsResult result, BindingResult error){
        if(error!=null&&error.hasErrors()){
            result.setStatus(Constant.Status.FAILED);
            try {
                result.setMsg(jsonMapper.writeValueAsString(error.getAllErrors()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }


}
