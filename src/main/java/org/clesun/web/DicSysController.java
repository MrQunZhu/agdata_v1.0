package org.clesun.web;

import org.clesun.entity.DicSys;
import org.clesun.entity.WsResult;
import org.clesun.exception.ServiceException;
import org.clesun.service.IDicSysService;
import org.clesun.utils.Constant;
import org.clesun.utils.MethodDescription;
import org.clesun.utils.Pagination;
import org.clesun.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping(value = "/dy/sysdic")
public class DicSysController extends AbsRest<DicSys>{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IDicSysService baseService;

    @MethodDescription("List")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Object list(Pagination<DicSys> pageinfo, HttpServletRequest request, HttpServletResponse resp) {
        WsResult result = new WsResult();
        WebUtils.setPageDataParameter(request, pageinfo,"_");
        List<DicSys> list = new ArrayList<DicSys>();
        pageinfo.setData(list);
        try {
            pageinfo = baseService.listByPageInfo(pageinfo);
            result.setStatus(Constant.Status.SUCCESS);
            result.setDatas(pageinfo);
        } catch (ServiceException e) {
            log.error(e);
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            resp.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }

    @MethodDescription("Get")
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object get(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse resp) {
        WsResult result = new WsResult();
        try {
            DicSys obj = baseService.getById(id);
            result.setStatus(Constant.Status.SUCCESS);
            result.setDatas(obj);

        } catch (ServiceException e) {
            log.error(e);
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            resp.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }


    @MethodDescription("Save")
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody DicSys object, HttpServletResponse resp) {
        WsResult result = new WsResult();
        try {
            if(isValid(result, null)){
                int rec = baseService.insert(object);
                result.setMsg(rec+" record opt");
            }
        } catch (ServiceException e) {
            log.error(e);
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            resp.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    };

    @MethodDescription("Update")
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public Object update(@RequestBody DicSys object,  HttpServletResponse resp) {
        WsResult result = new WsResult();
        try {
            if(isValid(result, null)){

                int rec = baseService.update(object);
                result.setMsg(rec+" record opt");
            }
        } catch (ServiceException e) {
            log.error(e);
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            resp.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    };

    @MethodDescription("Delete")
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse resp) {
        WsResult result = new WsResult();
        try {
            int rec = baseService.deleteById(id);
            result.setMsg(rec+" record opt");
        } catch (ServiceException e) {
            log.error(e);
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            resp.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }
}
