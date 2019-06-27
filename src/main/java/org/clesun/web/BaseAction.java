package org.clesun.web;

/**
 * Created by clesun on 2017/5/17.
 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 所有action的父类
 *
 */

public class BaseAction {

    protected final String FAILED="failed";
    protected final String SUCCESS="success";
    protected final String ERROR="error";
    protected final String EXCEPTION="exception";

    public void writeText(HttpServletResponse response, String... msg) throws IOException {
        write(response, "text/html", msg);
    }

    public void writeJson(HttpServletResponse response, String... msg) throws IOException {
        write(response, "application/json", msg);
    }

    public void writeXml(HttpServletResponse response, String... msg) throws IOException {
        write(response, "text/xml", msg);
    }

    public void write(HttpServletResponse response, String type, String... msg) throws IOException {
        response.setContentType(type + ";charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        for (String m : msg) {
            response.getWriter().write(m);
        }
        response.getWriter().flush();
        response.getWriter().close();
    }

    public HttpSession getSession(HttpServletRequest request) {
        return request.getSession(true);
    }



    /**
     * 清除Session内容<br>
     * 相对于ConstantCore中定义的 SESSION_* 项
     * @param req
     */
    protected void clearSession(HttpServletRequest req){
        Enumeration<String> attrs=req.getSession().getAttributeNames();
        while (attrs.hasMoreElements()){
            String attr=attrs.nextElement();
            req.getSession().removeAttribute(attr);
        }
    }
}
