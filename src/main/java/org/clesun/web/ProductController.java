package org.clesun.web;

import org.clesun.entity.DProduct;
import org.clesun.entity.WsResult;
import org.clesun.exception.ServiceException;
import org.clesun.service.IDProductService;
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
@RequestMapping(value = "/dy/product")
public class ProductController extends AbsRest<DProduct>{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IDProductService baseService;

    @MethodDescription("List")
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Object list(Pagination<DProduct> pageinfo, HttpServletRequest request, HttpServletResponse resp) {
        WsResult result = new WsResult();
        WebUtils.setPageDataParameter(request, pageinfo,"_");
        List<DProduct> list = new ArrayList<DProduct>();
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
            DProduct obj = baseService.getById(id);
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
    public Object save(@RequestBody DProduct object, HttpServletResponse resp) {
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
    public Object update(@RequestBody DProduct object,  HttpServletResponse resp) {
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

    /**
     * 批量删除
     * @author lxq
     * @DATE 2018/1/4
     * @param ids
     * @param request
     * @param resp
     * @return
     */
    @MethodDescription("BatchDelete")
    @ResponseBody
    @RequestMapping(value = "/batchDelete", method = RequestMethod.DELETE)
    public Object delete(String ids, HttpServletRequest request, HttpServletResponse resp) {
        WsResult result = new WsResult();
        String[] id = ids.split(",");
        try {
            int rec = baseService.batchDelete(id);
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
