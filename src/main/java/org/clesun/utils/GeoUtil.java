package org.clesun.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.clesun.entity.AdressDetailEntity;
import org.clesun.entity.DisTrictEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clesun on 2017/6/19.
 */
public class GeoUtil {
    public static String[] geo(DisTrictEntity arg1){
        String geoUrl = "http://restapi.amap.com/v3/geocode/geo?key=a0908b24f56fb0eb1f7855278276233f&output=JSON&address=";
        String[] res = new String[2];
        try{
            String param = "";
            if(null != arg1.getFormatted_address() && !"".equals(arg1.getFormatted_address())){
                param = arg1.getFormatted_address();
            }else{
                if(null != arg1.getTownship()&& !"".equals(arg1.getTownship())){
                    param = arg1.getTownship();
                }else{
                    if(null != arg1.getDistrict()&& !"".equals(arg1.getDistrict())){
                        param = arg1.getDistrict();
                    }else{
                        if(null != arg1.getCity()&& !"".equals(arg1.getCity())){
                            param = arg1.getCity();
                        }else {
                            param = arg1.getProvince();
                        }
                    }

                }
            }
            geoUrl += param;
            System.err.println("请求地址："+geoUrl);
            //            URL geoUrl = new URL("");
            String method = "GET";
            Map<String, String> headers = new HashMap<String, String>();

            HttpResponse response = HttpUtils.doGet(geoUrl,"",method,headers,null);
            try{
                HttpEntity entity = response.getEntity();
                System.err.println("response状态："+response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + entity.getContentLength());
                    // 打印响应内容
                    String jsonStr = IOUtils.toString(entity.getContent());

                    JSONObject jobj = JSONObject.fromObject(jsonStr);
                    if("0".equals(jobj.get("status").toString())){
                        System.err.println("info="+jobj.get("info"));
                        System.err.println("infocode="+jobj.get("infocode"));
                        return null;
                    }
                    JSONArray array =  jobj.getJSONArray("geocodes");
                    for(int i=0; i<array.size(); i++){
                        JSONObject jentity = JSONObject.fromObject(array.get(i));
                        String str = jentity.get("location").toString();
                        res = str.split(",");
                    }
                    return  res;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 关闭连接,释放资源
        }
        return null;
    }


    public static DisTrictEntity regeo(String[] lngLat){
        String regeoUrl = "http://restapi.amap.com/v3/geocode/regeo?key=a0908b24f56fb0eb1f7855278276233f&output=JSON&location=";
        System.err.println(StringUtils.join(lngLat,","));
        try{
            String param = StringUtils.join(lngLat,",");
            if("".equals(param)){
                return null;
            }
            regeoUrl += param;
            System.err.println("请求地址："+regeoUrl);
            //            URL geoUrl = new URL("");
            String method = "GET";
            Map<String, String> headers = new HashMap<String, String>();

            HttpResponse response = HttpUtils.doGet(regeoUrl,"",method,headers,null);
            try{
                HttpEntity entity = response.getEntity();
                System.err.println("response状态："+response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + entity.getContentLength());
                    // 打印响应内容
                    String jsonStr = IOUtils.toString(entity.getContent(),"UTF-8");
                    JSONObject jobj = JSONObject.fromObject(jsonStr);
                    if("0".equals(jobj.get("status").toString())){
                        System.err.println("info="+jobj.get("info"));
                        System.err.println("infocode="+jobj.get("infocode"));
                        return null;
                    }
                    DisTrictEntity res = new DisTrictEntity();
                    JSONObject object = (JSONObject) jobj.get("regeocode");
                    res.setFormatted_address(object.get("formatted_address").toString());

                    JSONObject object1 = (JSONObject) object.get("addressComponent");
                    res.setProvince(object1.get("province").toString());
                    res.setCity(object1.get("city").toString());
                    res.setCitycode(object1.get("citycode").toString());
                    res.setDistrict(object1.get("district").toString());
                    res.setAdcode(object1.get("adcode").toString());
                    res.setTownship(object1.get("township").toString());
                    res.setTowncode(object1.get("towncode").toString());


                    System.err.println(object1.get("province"));
                    return  res;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 关闭连接,释放资源
        }
        return null;
    }


    public static AdressDetailEntity getAdress(String arg1){
        String geoUrl = "http://restapi.amap.com/v3/geocode/geo?key=a0908b24f56fb0eb1f7855278276233f&output=JSON&address=";
        AdressDetailEntity adressDetailEntity = new AdressDetailEntity();
        try{
            String param = "";
            if(!"".equals(arg1) && null != arg1){
                param = arg1;
            }else {
                param = "大冶市";
            }
            geoUrl += param;
            System.err.println("请求地址："+geoUrl);
            //            URL geoUrl = new URL("");
            String method = "GET";
            Map<String, String> headers = new HashMap<String, String>();

            HttpResponse response = HttpUtils.doGet(geoUrl,"",method,headers,null);
            try{
                HttpEntity entity = response.getEntity();
                System.err.println("response状态："+response.getStatusLine());
                if (entity != null) {
                    // 打印响应内容长度
                    System.out.println("Response content length: " + entity.getContentLength());
                    // 打印响应内容
                    String jsonStr = IOUtils.toString(entity.getContent(),"utf-8");
                    System.out.print(jsonStr);
                    JSONObject jobj = JSONObject.fromObject(jsonStr);
                    if("0".equals(jobj.get("status").toString())){
                        System.err.println("info="+jobj.get("info"));
                        System.err.println("infocode="+jobj.get("infocode"));
                        return null;
                    }
                    JSONArray array =  jobj.getJSONArray("geocodes");
                    for(int i=0; i<array.size(); i++){
                        JSONObject jentity = JSONObject.fromObject(array.get(i));
                        String province = jentity.get("province").toString();
                        adressDetailEntity.setProvince(jentity.get("province").toString());
                        adressDetailEntity.setCity(jentity.get("city").toString());
                        adressDetailEntity.setCounty(jentity.get("district").toString());
                        adressDetailEntity.setAddress(jentity.get("formatted_address").toString());
                        String str = jentity.get("location").toString();
                        String[] res = str.split(",");
                        adressDetailEntity.setLng(res[0]);
                        adressDetailEntity.setLat(res[1]);
                    }
                    return  adressDetailEntity;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 关闭连接,释放资源
        }
        return null;
    }



    public static void main(String[] args){
        /*Long startTime = System.currentTimeMillis();
        DisTrictEntity disTrictEntity = new DisTrictEntity();
        disTrictEntity.setProvince("甘肃省");
        disTrictEntity.setCity("白银市");
        disTrictEntity.setDistrict("会宁县");
        disTrictEntity.setTownship("头寨镇");

        String[] res = GeoUtil.geo(disTrictEntity);
        System.out.println(res[0]+"="+res[1]);
        System.out.println(res.toString());

        System.out.println("========");
        String[] ar = {"104.755638","36.054981"};

        DisTrictEntity result = GeoUtil.regeo(ar);
        System.err.println(result);
        Long endTime = System.currentTimeMillis();*/

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");
        AdressDetailEntity adressDetailEntity = GeoUtil.getAdress("湖北省黄石市大冶市");
        System.out.println(adressDetailEntity.toString());
//        System.out.println("总共用时："+(endTime-startTime)+"毫秒");

    }
}
