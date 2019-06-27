package org.clesun.dao;

import org.apache.ibatis.annotations.Param;
import org.clesun.entity.IndustryEntity;
import org.clesun.entity.ProductDetail;
import org.clesun.entity.SingleStatisEntity;
import org.clesun.entity.StatisEntity;

import java.util.List;

public interface AgDataDao {
    //获取单项数据统计
    public SingleStatisEntity getSingleStatisData();
    //获取产业种类统计
    public List<IndustryEntity> getIndustryData(@Param("city") String city);

    /**
     * 获取种植业，畜牧业，水产业统计
     * @param city  城市
     * @param productName 作物种类
     * @param time 筛选时间,月，季度，年
     * @param type  类型，1：种植，2：水产，3：养殖，4：畜牧，5：蔬菜
     * @return  统计数据
     */
    public List<StatisEntity> getStatisData(@Param("city") String city, @Param("productName") String productName, @Param("time") String time, @Param("type") int type);

    /**
     * 获取城市列表
     * @return
     */
    public List<String> getCitys();

    /**
     * 获取产品名称
     * @return
     */
    public List<String> getProducts(@Param("type") int type);

    /**
     * 获取某一类产品具体统计信息
     * @param type
     * @return
     */
    public List<ProductDetail> getProductsInfo(int type);

    /**
     * 获取种植，水产的信息，为了解决养殖与种植水产字段不一样而补充适配
     * @param type
     * @return
     */
    public List<ProductDetail> getProductsInfoFix(int type);

}
