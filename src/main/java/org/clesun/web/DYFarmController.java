package org.clesun.web;

import net.sf.json.JSONObject;
import org.clesun.entity.DEquipmentParameter;
import org.clesun.entity.DyEquipment;
import org.clesun.entity.DyFarmEquipment;
import org.clesun.entity.WsResult;
import org.clesun.exception.ServiceException;
import org.clesun.service.DyChannelinfoService;
import org.clesun.service.DyFarmEquipmentService;
import org.clesun.service.DyXzDataService;
import org.clesun.utils.Constant;
import org.clesun.utils.HelloUtil;
import org.clesun.utils.MethodDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by clesun on 2017/8/14.
 */
@RestController
@RequestMapping(value = "/dyFarm")
public class DYFarmController extends AbsRest<Object> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DyChannelinfoService dyChannelinfoService;
    @Autowired
    private DyFarmEquipmentService farmEquipmentService;
    @Autowired
    private DyXzDataService dyXzDataService;

    /**
     * 查询大冶物联网设备数据
     * @author lxq
     * @DATE 2017/8/17
     * @param request
     * @param resp
     * @return
     */
    @MethodDescription("List")
    @ResponseBody
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Object list(HttpServletRequest request, HttpServletResponse resp) {
        WsResult result = new WsResult();
        try {
            List<DyEquipment> data = dyChannelinfoService.getEquipmentList();
            result.setStatus(Constant.Status.SUCCESS);
            result.setDatas(data);
        } catch (Exception e) {
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            resp.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }

    /**
     * 查询所有物联网设备数据
     * @author lxq
     * @DATE 2018/1/16
     * @param request
     * @param resp
     * @return
     */
    @MethodDescription("List")
    @ResponseBody
    @RequestMapping(value = "/equipmentList",method = RequestMethod.GET)
    public Object equipmentList(String cityName,String postCode,HttpServletRequest request, HttpServletResponse resp) {
        WsResult result = new WsResult();
        try {
            List<DEquipmentParameter> data = dyChannelinfoService.getEquipmentParameters(cityName,postCode);
            result.setStatus(Constant.Status.SUCCESS);
            result.setDatas(data);
        } catch (Exception e) {
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            resp.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }

    /**
     * 查询物联网设备实时数据
     * @author lxq
     * @DATE 2017/8/17
     * @param addr
     * @param resp
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRealTimeData",method = RequestMethod.GET)
    public Object getRealTimeData(String addr, HttpServletResponse resp){
        WsResult result = new WsResult();
        try {
            result.setDatas(dyChannelinfoService.getEquipmentInfo(addr));
            result.setStatus(Constant.Status.SUCCESS);
        } catch (ServiceException e) {
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            resp.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }


    /**
     * 查询物联网设备历史数据
     * @author lxq
     * @DATE 2017/8/17
     * @param addr
     * @param startTime
     * @param endTime
     * @param request
     * @param resp
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getData",method = RequestMethod.GET)
    public Object getData(String addr,String startTime,String endTime,HttpServletRequest request, HttpServletResponse resp){
        WsResult result = new WsResult();
        try {
            result.setDatas(dyChannelinfoService.getByAddr(addr,startTime,endTime));
            result.setStatus(Constant.Status.SUCCESS);
        } catch (ServiceException e) {
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            resp.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }


    /**
     * 查询大冶气象数据
     * @author lxq
     * @DATE 2017/8/17
     * @param startTime
     * @param endTime
     * @param request
     * @param resp
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getXZData",method = RequestMethod.GET)
    public Object getXzData(String cityName,String startTime,String endTime,HttpServletRequest request, HttpServletResponse resp){
        WsResult result = new WsResult();
        try {
            result.setDatas(dyXzDataService.getXzData(cityName,startTime,endTime));
            result.setStatus(Constant.Status.SUCCESS);
        } catch (ServiceException e) {
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            resp.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }

    /**
     * 批量新增农场设备关联关系
     * @author lxq
     * @DATE 2017/8/17
     * @param request
     * @param resp
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addFarmEquipment",method = RequestMethod.GET)
    public Object addFarmEquipment(HttpServletRequest request, HttpServletResponse resp){
        WsResult result = new WsResult();
        String addr = "60882952";
        try {
            List<DyFarmEquipment> list = new ArrayList<DyFarmEquipment>();
            String[] addrs = addr.split(",");
            for (int i = 0; i < addrs.length; i++) {
                String url = "http://219.138.66.111:89//qfls/api";
                Map<String,String> map = new HashMap<>();
                map.put("username","clesundev");
                map.put("sessionkey","239A506CD4E38A8757A2314442146CF3");
                map.put("method","getRealTimeDeviceDetailData");
                map.put("addr",addrs[i]);
                String data = HelloUtil.sendGet(url,map);
                JSONObject jsonObject = JSONObject.fromObject(data);
                Long farmId = Long.valueOf(jsonObject.get("custid").toString());
                DyFarmEquipment dyFarmEquipment = new DyFarmEquipment();
                dyFarmEquipment.setFarmId(farmId);
                dyFarmEquipment.setAddr(addrs[i]);
                list.add(dyFarmEquipment);
            }
            result.setDatas(farmEquipmentService.insertAll(list));
            result.setStatus(Constant.Status.SUCCESS);
        } catch (ServiceException e) {
            result.setStatus(Constant.Status.FAILED);
            result.setMsg(e.getMessage());
            result.setDatas(null);
            resp.setStatus(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
        return result;
    }
}
