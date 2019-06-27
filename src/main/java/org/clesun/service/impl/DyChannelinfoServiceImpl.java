package org.clesun.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.clesun.dao.DEquipmentParameterMapper;
import org.clesun.dao.DyEquipmentChannelinfoMapper;
import org.clesun.dao.DyEquipmentMapper;
import org.clesun.dao.DyFarmEquipmentMapper;
import org.clesun.entity.*;
import org.clesun.exception.ServiceException;
import org.clesun.service.DyChannelinfoService;
import org.clesun.utils.HelloUtil;
import org.clesun.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by clesun on 2017/5/17.
 */
@SuppressWarnings("ALL")
@Service
public class DyChannelinfoServiceImpl implements DyChannelinfoService {
    @Autowired
    private DyEquipmentChannelinfoMapper baseMapper;

    @Autowired
    private DyFarmEquipmentMapper farmEquipmentMapper;

    @Autowired
    private DyEquipmentMapper equipmentMapper;

    @Autowired
    private DEquipmentParameterMapper parameterMapper;

    @Override
    public int deleteById(Long id) throws ServiceException {


        try {
            return baseMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }


    }

    @Override
    public List<DyEquipmentChannelinfo> findAll() throws ServiceException {
        try {
            DyEquipmentChannelinfoExample example = new DyEquipmentChannelinfoExample();
            return baseMapper.selectByExample(example);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }


    @Override
    public DyEquipmentChannelinfo getById(Long id) throws ServiceException {
        try {
            return baseMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int insert(DyEquipmentChannelinfo o) throws ServiceException {
        try {
            return baseMapper.insertSelective(o);
        } catch (DuplicateKeyException e){
            throw new ServiceException("data already exsist!!!");

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Pagination<DyEquipmentChannelinfo> listByPageInfo(Pagination<DyEquipmentChannelinfo> page)	throws ServiceException {

        DyEquipmentChannelinfoExample example = new DyEquipmentChannelinfoExample();
        try {
            if (page.getFiltrations() != null && page.getFiltrations().size() > 0) {
                DyEquipmentChannelinfoExample.Criteria criteria = example.createCriteria();
                for (Filtration filteration : page.getFiltrations()) {
                    criteria.addCriterion(filteration.getCondition(), filteration.getFieldValue(), filteration.getFieldName());
                }
            }
            page.setTotalRowCount(baseMapper.countByExample(example));
            example.setOffset(page.getOffset());
            example.setLimit(page.getRowsOfPage());

            if (page.getCompositors() != null) {
                StringBuffer sb=new StringBuffer();
                for(Compositor comp:page.getCompositors()){
                    sb.append(comp.getFieldName()+" "+comp.getCompositorType().toString() +",");
                }
                example.setOrderByClause(sb.deleteCharAt(sb.length()-1).toString());
            } else {
                example.setOrderByClause("channelinfo_id");
            }

            page.setData(baseMapper.selectByExample(example));

        } catch (Exception e) {
            throw new ServiceException(e);
        }
        return page;
    }

    @Override
    public int update(DyEquipmentChannelinfo o) throws ServiceException {

        try {

            return baseMapper.updateByPrimaryKeySelective(o);
        } catch (DuplicateKeyException e){
            throw new ServiceException("data already exsist!!!");
        }catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * 获取设备数据
     * 修改时间2017/11/14
     * @author lxq
     * @DATE 2017/8/15
     * @param addr
     * @return
     */
    @Override
    public Map<String,Object> getByAddr(String addr, String startTime, String endTime) {
        Map<String,Object> result = new HashMap<String, Object>();
        DyEquipmentChannelinfoExample example = new DyEquipmentChannelinfoExample();
        example.createCriteria().andAddrEqualTo(addr);
        List<DyEquipmentChannelinfo> list = baseMapper.selectByExample(example);
        if(list!=null && list.size()>0){
            DyEquipmentChannelinfo channelinfo = list.get(0);
            String url = "http://api.nongyongtong.com:8081/qfls/api";
            Map<String,String> map = new HashMap<String,String>();
            map.put("method","getDeviceSensorDataFromTime");
            map.put("sessionkey","239A506CD4E38A8757A2314442146CF3");
            map.put("addr",addr);
            map.put("startTime",startTime);
            map.put("endTime",endTime);
            String data = HelloUtil.sendGet(url,map);
            net.sf.json.JSONObject object = net.sf.json.JSONObject.fromObject(data);
            List<Map<String,Object>> airTemperatures = new ArrayList<Map<String,Object>>();
            List<Map<String,Object>> airHumiditys = new ArrayList<Map<String,Object>>();
            List<Map<String,Object>> rainfalls = new ArrayList<Map<String,Object>>();
            List<Map<String,Object>> weeds = new ArrayList<Map<String,Object>>();
            List<Map<String,Object>> soilHumiditys = new ArrayList<Map<String,Object>>();
            List<Map<String,Object>> dates = new ArrayList<Map<String,Object>>();
            DecimalFormat    df   = new DecimalFormat("######0.00");
            //判断弄用通接口是否返回有数据
            if(object.containsKey("addr")){
                net.sf.json.JSONArray jsonArray = object.getJSONArray("dataarr");
                for (int i = 0; i <jsonArray.size() ; i++) {
                    Map<String,Object> airTemperature = new HashMap<String, Object>();
                    Map<String,Object> airHumidity = new HashMap<String, Object>();
                    Map<String,Object> rainfall = new HashMap<String, Object>();
                    Map<String,Object> weed = new HashMap<String, Object>();
                    Map<String,Object> date = new HashMap<String, Object>();
                    Map<String,Object> soilHumidity = new HashMap<String, Object>();
                    airTemperature.put("value",jsonArray.getJSONObject(i).get(channelinfo.getAirtemperature()));
                    airTemperatures.add(airTemperature);
                    airHumidity.put("value",jsonArray.getJSONObject(i).get(channelinfo.getAirhumidity()));
                    airHumiditys.add(airHumidity);
                    rainfall.put("value",jsonArray.getJSONObject(i).get(channelinfo.getRainfall()));
                    rainfalls.add(rainfall);
                    weed.put("name",jsonArray.getJSONObject(i).get(channelinfo.getWinddirection()));
                    String weedResult = "0.0";
                    if(null != channelinfo.getWindspeed()){
                        weedResult = (jsonArray.getJSONObject(i).get(channelinfo.getWindspeed())).toString();
                    }
                    //风速转换为Km/h
                    String windSpeed = df.format(Double.parseDouble(weedResult)*3.6);
                    weed.put("y",windSpeed);
                    weeds.add(weed);
                    date.put("value",jsonArray.getJSONObject(i).get("gatherTime"));
                    dates.add(date);
                    soilHumidity.put("value",jsonArray.getJSONObject(i).get(channelinfo.getSoilhumidity()));
                    soilHumiditys.add(soilHumidity);
                }
            }
            result.put("airTemperature",airTemperatures);
            result.put("airHumidity",airHumiditys);
            result.put("rainfall",rainfalls);
            result.put("weed",weeds);
            result.put("date",dates);
            result.put("soilHumidity",soilHumiditys);
        }
        return result;
    }

    /**
     * 获取所有设备信息（坐标）
     * @return
     * @author lxq
     * @DATE 2017/11/14
     */
    @Override
    public List<DyEquipment> getEquipments() {
        List<DyEquipment> list = null;
        try {
            DyEquipmentExample example = new DyEquipmentExample();
            list = equipmentMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取大冶所有气象设备
     *
     * @return
     * @throws ServiceException
     * @author lxq
     * @DATE 2017/11/14
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<DyEquipment> getEquipmentList() throws ServiceException {
        String url = "http://api.nongyongtong.com:8081/qfls/api";
        Map<String,String> map = new HashMap<>();
        map.put("businessUsername","scnkyyys");
        map.put("sessionkey","239A506CD4E38A8757A2314442146CF3");
        map.put("method","getDeviceByUsername");
        map.put("havechannel","1");
        String data = HelloUtil.sendGet(url,map);
        List<DyEquipment> list = new ArrayList<>();
        DEquipmentParameter parameter = new DEquipmentParameter();
        try {
            JSONArray array = JSONArray.parseArray(data);
            //判断接口是否返回有效值
            if(array != null && array.size()>0){
                for (int i = 0; i < array.size(); i++) {
                    //判断符合条件的设备组
                    JSONArray equipments = (JSONArray) array.getJSONObject(i).get("devarr");
                    if(equipments != null && equipments.size()>0){
                        for (int j = 0; j < equipments.size(); j++) {
                            JSONObject object = equipments.getJSONObject(j);
                            if(object.getIntValue("unittype")==1){
                                DyEquipmentEntity equipment = new DyEquipmentEntity();
                                equipment.setWorkUnitName(object.get("unitname").toString());
                                parameter.setEquipmentUnitname(object.get("unitname").toString());
                                equipment.setAddr(object.get("addr").toString());
                                parameter.setEquipmentAddr(object.get("addr").toString());
                                equipment.setBaseName(array.getJSONObject(i).get("orgname").toString());
                                parameter.setEquipmentOrgname(array.getJSONObject(i).get("orgname").toString());
                                if(object.containsKey("address")){
                                    if(!"".equals(object.get("address").toString())){
                                        equipment.setAddress(object.get("address").toString());
                                        parameter.setEquipmentAddress(object.get("address").toString());
                                    }else {
                                        equipment.setAddress("未知");
                                        parameter.setEquipmentAddress("未知");
                                    }
                                }else{
                                    equipment.setAddress("未知");
                                    parameter.setEquipmentAddress("未知");
                                }
                                parameter.setEquipmentUnittype(object.get("unittype").toString());
                                JSONArray jsonArray = (JSONArray) object.get("geom");
                                equipment.setEquipmentLng(Double.valueOf(jsonArray.get(0).toString()));
                                parameter.setEquipmentLng(Double.valueOf(jsonArray.get(0).toString()));
                                equipment.setEquipmentLat(Double.valueOf(jsonArray.get(1).toString()));
                                parameter.setEquipmentLat(Double.valueOf(jsonArray.get(1).toString()));
                                list.add(equipment);

                                //获取设备所有传感器通道名称
                                JSONArray columns =  object.getJSONArray("channelarr");
                                DyEquipmentChannelinfo channelinfo = new DyEquipmentChannelinfo();
                                channelinfo.setAddr(object.get("addr").toString());

                                //循环所有通道获取通道名称
                                for (int k = 0; k < columns.size(); k++) {
                                    JSONObject column = columns.getJSONObject(k);
                                    String key = column.get("channelType").toString();

                                    switch (key){
                                        case "13":
                                            //土壤湿度
                                            String soilHumColumnName = column.get("Chx").toString();
                                            if("".equals(channelinfo.getSoilhumidity()) || channelinfo.getSoilhumidity() == null){
                                                channelinfo.setSoilhumidity(soilHumColumnName);
                                            }
                                            break;
                                        case "12":
                                            //土壤温度
                                            String soilTempColumnName = column.get("Chx").toString();
                                            if("".equals(channelinfo.getSoiltemperature()) || channelinfo.getSoiltemperature() == null){
                                                channelinfo.setSoiltemperature(soilTempColumnName);
                                            }
                                            break;
                                        case "47":
                                            //大气压力
                                            String pressureColumnName = column.get("Chx").toString();
                                            channelinfo.setPressure(pressureColumnName);
                                            break;
                                        case "24":
                                            //降雨量
                                            String railFallColumnName = column.get("Chx").toString();
                                            if(("".equals(channelinfo.getRainfall()) || channelinfo.getRainfall() == null)){
                                                //排除累计降雨量
                                                if(!column.get("DisplayName").toString().contains("累计")){
                                                    channelinfo.setRainfall(railFallColumnName);
                                                }
                                            }
                                            break;
                                        case "11":
                                            //空气湿度
                                            String airHumColumnName = column.get("Chx").toString();
                                            channelinfo.setAirhumidity(airHumColumnName);
                                            break;
                                        case "10":
                                            //空气温度
                                            String airTempColumnName = column.get("Chx").toString();
                                            channelinfo.setAirtemperature(airTempColumnName);
                                            break;
                                        case "14":
                                            //光照
                                            channelinfo.setIllumination(column.get("Chx").toString());
                                            break;
                                        case "38":
                                            //电能量
                                            channelinfo.setElectrical(column.get("Chx").toString());
                                            break;
                                        case "23":
                                            //风速
                                            String windSpeedColumnName = column.get("Chx").toString();
                                            if("".equals(channelinfo.getWindspeed()) || channelinfo.getWindspeed() == null){
                                                channelinfo.setWindspeed(windSpeedColumnName);
                                            }else{
                                                String displayName = column.get("DisplayName").toString();
                                                if(displayName.contains("平均")){
                                                    channelinfo.setWindspeed(windSpeedColumnName);
                                                }
                                            }
                                            break;
                                        case "27":
                                            //风向
                                            String windDirectionColumnName = column.get("Chx").toString();
                                            if("".equals(channelinfo.getWinddirection()) || channelinfo.getWinddirection() == null){
                                                channelinfo.setWinddirection(windDirectionColumnName);
                                            }
                                            break;
                                        default:
                                            break;
                                    }

                                }
                                parameter.setCityName("成都市");
                                parameter.setPostCode("510100000000");
                                //===================组装数据 end=================

                                //查询设备是否存在
                                DEquipmentParameterExample example = new DEquipmentParameterExample();
                                example.createCriteria().andEquipmentAddrEqualTo(object.get("addr").toString());
                                List<DEquipmentParameter> parameters = parameterMapper.selectByExample(example);
                                //判断设备是否已经存在 设备不存在则进行保存,存在则进行更新
                                if(null == parameters || parameters.size() <= 0){
                                    parameterMapper.insert(parameter);
                                    baseMapper.insert(channelinfo);
                                }else{
                                    parameter.setParamentId(parameters.get(0).getParamentId());
                                    parameterMapper.updateByPrimaryKey(parameter);

                                    DyEquipmentChannelinfoExample equipmentExample = new DyEquipmentChannelinfoExample();
                                    equipmentExample.createCriteria().andAddrEqualTo(object.get("addr").toString());
                                    baseMapper.updateByExampleSelective(channelinfo,equipmentExample);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取某一设备详细信息和实时数据
     * @param addr
     * @return
     * @author lxq
     * @DATE 2017/11/14
     */
    @Override
    public Map<String,Object> getEquipmentInfo(String addr) {
        DyEquipmentEntity equipmentEntity = new DyEquipmentEntity();
        String url = "http://api.nongyongtong.com:8081/qfls/api";
        Map<String,String> map = new HashMap<String,String>();
        map.put("method","getRealTimeDeviceDetailData");
        map.put("sessionkey","239A506CD4E38A8757A2314442146CF3");
        map.put("addr",addr);
        Map<String,Object> mapData = new HashMap<String,Object>();
        DecimalFormat    df   = new DecimalFormat("######0.00");
        try {
            String data = HelloUtil.sendGet(url,map);
            net.sf.json.JSONObject object = net.sf.json.JSONObject.fromObject(data);
            //判断是否有数据
            if(object.containsKey("Addr")){
                DyEquipmentChannelinfoExample example = new DyEquipmentChannelinfoExample();
                example.createCriteria().andAddrEqualTo(addr);
                List<DyEquipmentChannelinfo> list = baseMapper.selectByExample(example);
                if(list != null && list.size()>0){
                    DyEquipmentChannelinfo channelinfo = list.get(0);
                    net.sf.json.JSONArray jsonArray = object.getJSONArray("sensorValue");
                    for (int i = 0; i < jsonArray.size(); i++) {
                        net.sf.json.JSONObject jsonObject = jsonArray.getJSONObject(i);
                        if(channelinfo.getAirtemperature().equals(jsonObject.get("Chx"))){
                            mapData.put("airTemperature",jsonObject.get("chValue"));
                        }else if(channelinfo.getAirhumidity().equals(jsonObject.get("Chx"))){
                            mapData.put("airHumidity",jsonObject.get("chValue"));
                        }else if(channelinfo.getSoilhumidity().equals(jsonObject.get("Chx"))){
                            mapData.put("soilHumidity",jsonObject.get("chValue"));
                        }else if(channelinfo.getRainfall().equals(jsonObject.get("Chx"))){
                            mapData.put("rainfall",jsonObject.get("chValue"));
                        }else if(channelinfo.getWindspeed().equals(jsonObject.get("Chx"))){
                            String speed = df.format(Double.parseDouble(jsonObject.get("chValue").toString())*3.6);
                            mapData.put("windspeed",speed);
                        }else if(channelinfo.getWinddirection().equals(jsonObject.get("Chx"))){
                            mapData.put("winddirection",jsonObject.get("chValue"));
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapData;
    }

    /**
     * 查询所有设备数据
     *
     * @return
     * @author lxq
     * @DATE 2018/1/16
     */
    @Override
    public List<DEquipmentParameter> getEquipmentParameters(String cityName,String postCode) {
        List<DEquipmentParameter> list = null;
        try {
            DEquipmentParameterExample example = new DEquipmentParameterExample();
            example.createCriteria().andCityNameEqualTo(cityName);
            example.createCriteria().andPostCodeEqualTo(postCode);
            list = parameterMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}