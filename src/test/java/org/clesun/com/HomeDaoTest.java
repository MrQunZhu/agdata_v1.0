package org.clesun.com;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import net.sf.json.JSONObject;
import org.clesun.entity.LngLatEntity;
import org.clesun.service.IDFarmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by clesun on 2017/3/16.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/spring-dao.xml","classpath*:spring/spring-service.xml"})
public class HomeDaoTest {
    public static void main(String[] args) {
        /*String a = "总产量（头）";
        String b = "价格（元/公斤）";
        System.out.print(a.substring(4,a.length()-1));
        System.out.print(b.substring(3,b.length()-1));
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        System.out.print(calendar.get(Calendar.DAY_OF_MONTH));*/
        String json = "{geo:[123456.1234567809,345678.1234567809]}";
        com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(json);
        JSONArray list = object.getJSONArray("geo");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }


        //JSON object = JSON.parseObject(objects.get("geo").toString());
        //System.out.print(object);
        //JSONArray obj = JSON.parseArray(object.get("geo").toString());

        //System.out.print(obj.get(0)+"\n"+obj.get(1));
    }

    @Autowired
    private IDFarmService farmService;

    @Test
    public void test(){
        Date time = new Date(System.currentTimeMillis());
        System.out.println(time);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dfdate = df.format(time);
        System.out.println(dfdate);
        String[] ymd = dfdate.split("-");
        System.out.println(ymd[0]);
        System.out.println(ymd[1]);
        System.out.println(ymd[2]);
    }

    @Test
    public void changeDfarmRangeTest(){
        /*List<DFarm> list = farmService.getNotInRangeFarmList("湖北省","大冶市");
        if(null != list && list.size()>0){
            for (DFarm farm : list){
                String address = "湖北省大冶市"+farm.getFarmAddress();
                address = address.replace(" ","");
                AdressDetailEntity addressDetail = GeoUtil.getAdress(address);
                farm.setFarmProvince(addressDetail.getProvince());
                farm.setFarmCity(addressDetail.getCity());
                farm.setFarmCounty(addressDetail.getCounty());
                farm.setLocationLng(Double.valueOf(addressDetail.getLng()));
                farm.setLocationLat(Double.valueOf(addressDetail.getLat().toString()));
//                try {
//                    farmService.update(farm);
//                } catch (ServiceException e) {
//                    e.printStackTrace();
//                }
                System.out.println(addressDetail.toString());
            }
        }*/

     /*   AdressDetailEntity addressDetail = GeoUtil.getAdress("湖北省大冶市保安镇青山村");
        System.out.println(addressDetail);*/

    }


}
