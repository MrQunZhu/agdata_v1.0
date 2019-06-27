package org.clesun.web;

import org.clesun.entity.*;
import org.clesun.service.IAgDataService;
import org.clesun.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;
import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping(value = "/dy/agdata")
public class AgDataController extends AbsRest<Object> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IAgDataService baseService;

    //单项统计
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET,value = "/singlestatis")
    public Object singlestatis(HttpServletRequest request, HttpServletResponse resp) {
        WsResult result = new WsResult();
        try {
            SingleStatisEntity obj = baseService.getSingleStatisData();
            result.setStatus(Constant.Status.SUCCESS);
            result.setDatas(obj);

        } catch (Exception e) {
            log.error(e);
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            resp.setStatus(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }

    //产业种类
    @RequestMapping(value = "/industrystatis")
    public Object industryStatis(@PathParam("city") String city, HttpServletRequest request, HttpServletResponse response){
        WsResult result = new WsResult();
        try {
            List<IndustryEntity> obj = baseService.getIndustryData(city);
            result.setStatus(Constant.Status.SUCCESS);
            result.setDatas(obj);
        } catch (Exception e) {
            log.error(e);
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            response.setStatus(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }

    //种植
    @RequestMapping(value = "/plantstatis")
    public Object plantStatis(@PathParam("city") String city,
                              @PathParam("productName") String productName,
                              @PathParam("time") String time,
                              HttpServletRequest request, HttpServletResponse response){
        WsResult result = new WsResult();
        try {
            List<StatisEntity> obj = baseService.getStatisData(city, productName, time, 1);
            result.setStatus(Constant.Status.SUCCESS);
            result.setDatas(obj);
        } catch (Exception e) {
            log.error(e);
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            response.setStatus(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }

    //畜牧
    @RequestMapping(value = "/animalstatis")
    public Object animalStatis(@PathParam("city") String city,
                               @PathParam("productName") String productName,
                               @PathParam("time") String time,
                               HttpServletRequest request, HttpServletResponse response){
        WsResult result = new WsResult();
        try {
            List<StatisEntity> obj = baseService.getStatisData(city, productName, time, 4);
            result.setStatus(Constant.Status.SUCCESS);
            result.setDatas(obj);
        } catch (Exception e) {
            log.error(e);
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            response.setStatus(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }

    //水产
    @RequestMapping(value = "/aquaticstatis")
    public Object aquaticStatis(@PathParam("city") String city,
                                @PathParam("productName") String productName,
                                @PathParam("time") String time,
                                HttpServletRequest request, HttpServletResponse response){
        WsResult result = new WsResult();
        try {
            List<StatisEntity> obj = baseService.getStatisData(city, productName, time, 2);
            result.setStatus(Constant.Status.SUCCESS);
            result.setDatas(obj);
        } catch (Exception e) {
            log.error(e);
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            response.setStatus(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }

    //加工
    @RequestMapping(value = "/processstatis")
    public Object processStatis(@PathParam("city") String city,
                                @PathParam("productName") String productName,
                                @PathParam("time") String time,
                                HttpServletRequest request, HttpServletResponse response){
        WsResult result = new WsResult();
        try {
            List<StatisEntity> obj = baseService.getStatisData(city, productName, time, 5);
            result.setStatus(Constant.Status.SUCCESS);
            result.setDatas(obj);
        } catch (Exception e) {
            log.error(e);
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            response.setStatus(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }

    @RequestMapping(value = "/getcitys")
    public Object getCitys(HttpServletRequest request, HttpServletResponse response){
        WsResult result = new WsResult();
        try {
            List<String> obj = baseService.getCitys();
            result.setStatus(Constant.Status.SUCCESS);
            result.setDatas(obj);
        } catch (Exception e) {
            log.error(e);
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            response.setStatus(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }

    @RequestMapping(value = "/getproducts/{type}")
    public Object getProducts(@PathVariable("type") Integer type,
                              HttpServletRequest request, HttpServletResponse response){
        WsResult result = new WsResult();
        try {
            if(null == type){
                type = 1;
            }

            List<String> obj = baseService.getProducts(type);
            result.setStatus(Constant.Status.SUCCESS);
            result.setDatas(obj);
        } catch (Exception e) {
            log.error(e);
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            response.setStatus(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }

    @RequestMapping(value = "/getproductsinfo/{type}")
    public Object getProductsInfo(@PathVariable("type") Integer type,
                              HttpServletRequest request, HttpServletResponse response){
        WsResult result = new WsResult();
        try {
            if(null == type){
                type = 1;
            }

            List<ProductDetail> obj = baseService.getProductsInfo(type);
            result.setStatus(Constant.Status.SUCCESS);
            result.setDatas(obj);
        } catch (Exception e) {
            log.error(e);
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            response.setStatus(javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }



}
