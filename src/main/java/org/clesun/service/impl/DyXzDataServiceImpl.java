package org.clesun.service.impl;

import org.clesun.dao.DyXzDataMapper;
import org.clesun.entity.Compositor;
import org.clesun.entity.DyXzData;
import org.clesun.entity.DyXzDataExample;
import org.clesun.entity.Filtration;
import org.clesun.exception.ServiceException;
import org.clesun.service.DyXzDataService;
import org.clesun.utils.DateUtils;
import org.clesun.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by clesun on 2017/5/17.
 */
@SuppressWarnings("ALL")
@Service
public class DyXzDataServiceImpl implements DyXzDataService{
    @Autowired
    private DyXzDataMapper baseMapper;

    @Override
    public int deleteById(Long id) throws ServiceException {


        try {
            return baseMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }


    }

    @Override
    public List<DyXzData> findAll() throws ServiceException {
        try {
            DyXzDataExample example = new DyXzDataExample();
            return baseMapper.selectByExample(example);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }


    @Override
    public DyXzData getById(Long id) throws ServiceException {
        try {
            return baseMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int insert(DyXzData o) throws ServiceException {
        try {
            return baseMapper.insertSelective(o);
        } catch (DuplicateKeyException e){
            throw new ServiceException("data already exsist!!!");

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Pagination<DyXzData> listByPageInfo(Pagination<DyXzData> page)	throws ServiceException {

        DyXzDataExample example = new DyXzDataExample();
        try {
            if (page.getFiltrations() != null && page.getFiltrations().size() > 0) {
                DyXzDataExample.Criteria criteria = example.createCriteria();
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
                example.setOrderByClause("data_id");
            }

            page.setData(baseMapper.selectByExample(example));

        } catch (Exception e) {
            throw new ServiceException(e);
        }
        return page;
    }

    @Override
    public int update(DyXzData o) throws ServiceException {

        try {

            return baseMapper.updateByPrimaryKeySelective(o);
        } catch (DuplicateKeyException e){
            throw new ServiceException("data already exsist!!!");
        }catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Map<String,Object> getXzData(String cityName,String startTime, String endTime) throws ServiceException {
        DyXzDataExample example = new DyXzDataExample();
        List<DyXzData> list = null;
        Date start = DateUtils.stringToDate(startTime,"yyyy-MM-dd HH:mm:ss");
        Date end = DateUtils.stringToDate(endTime,"yyyy-MM-dd HH:mm:ss");
        example.createCriteria().andCreateTimeBetween(start,end).andCityNameEqualTo(cityName);
        example.setOrderByClause("create_time desc");
        list = baseMapper.selectByExample(example);
        Map<String,Object> result = new HashMap<String, Object>();
        if(list!=null && list.size()>0){
            List<Map<String,Object>> airTemperatures = new ArrayList<Map<String,Object>>();
            List<Map<String,Object>> airHumiditys = new ArrayList<Map<String,Object>>();
            List<Map<String,Object>> rainfalls = new ArrayList<Map<String,Object>>();
            List<Map<String,Object>> weeds = new ArrayList<Map<String,Object>>();
            List<Map<String,Object>> soilHumiditys = new ArrayList<Map<String,Object>>();
            List<Map<String,Object>> dates = new ArrayList<Map<String,Object>>();
            for (int i = 0; i <list.size() ; i++) {
                DyXzData dyXzData = list.get(i);
                Map<String,Object> airTemperature = new HashMap<String, Object>();
                Map<String,Object> airHumidity = new HashMap<String, Object>();
                Map<String,Object> rainfall = new HashMap<String, Object>();
                Map<String,Object> weed = new HashMap<String, Object>();
                Map<String,Object> date = new HashMap<String, Object>();
                Map<String,Object> soilHumidity = new HashMap<String, Object>();
                airTemperature.put("value",dyXzData.getAirtemperature());
                airTemperatures.add(airTemperature);
                airHumidity.put("value",dyXzData.getAirhumidity());
                airHumiditys.add(airHumidity);
                rainfall.put("value",dyXzData.getRainfall());
                rainfalls.add(rainfall);
                weed.put("name",dyXzData.getWinddirection());
                weed.put("y",dyXzData.getWindspeed());
                weeds.add(weed);
                date.put("value", DateUtils.formatDate(dyXzData.getCreateTime(),"yyyy-MM-dd HH:mm:ss"));
                dates.add(date);
                soilHumidity.put("value",dyXzData.getSoilhumidity());
                soilHumiditys.add(soilHumidity);
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
}
