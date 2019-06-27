package org.clesun.service.impl;

import org.clesun.dao.AgDataDao;
import org.clesun.entity.IndustryEntity;
import org.clesun.entity.ProductDetail;
import org.clesun.entity.SingleStatisEntity;
import org.clesun.entity.StatisEntity;
import org.clesun.service.IAgDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class AgDataServiceImpl implements IAgDataService {
    @Autowired
    private AgDataDao baseDao;
    @Override
    public SingleStatisEntity getSingleStatisData() {
        return baseDao.getSingleStatisData();
    }

    @Override
    public List<IndustryEntity> getIndustryData(String city) {
        if("".equals(city) || null == city){
            city = null;
        }
        return baseDao.getIndustryData(city);
    }

    @Override
    public List<StatisEntity> getStatisData(String city, String productName, String time, int type) {
        if("".equals(city) || null == city){
            city = null;
        }
        if("".equals(productName) || null == productName){
            productName = null;
        }
        if("".equals(time) || null == time){
            time = "mth"; //默认按月统计
        }
        return baseDao.getStatisData(city,productName,time,type);
    }

    @Override
    public List<String> getCitys() {
        return baseDao.getCitys();
    }

    @Override
    public List<String> getProducts(int type) {
        return baseDao.getProducts(type);
    }

    @Override
    public List<ProductDetail> getProductsInfo(int type) {
        List<ProductDetail> list = null;
        if (1 == type || 2 == type || 5 == type){
            list = baseDao.getProductsInfoFix(type);
        }else{
            list = baseDao.getProductsInfo(type);
        }

        return list;
    }
}
