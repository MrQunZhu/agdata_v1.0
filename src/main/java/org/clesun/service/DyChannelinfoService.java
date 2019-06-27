package org.clesun.service;

import org.clesun.entity.DEquipmentParameter;
import org.clesun.entity.DyEquipment;
import org.clesun.entity.DyEquipmentChannelinfo;
import org.clesun.exception.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * Created by clesun on 2017/5/17.
 */
public interface DyChannelinfoService extends ICoreService<DyEquipmentChannelinfo, Long> {
    /**
     * 获取设备数据
     * 修改时间2017/11/14
     * @author lxq
     * @DATE 2017/8/15
     * @param addr
     * @return
     */
    Map<String,Object> getByAddr(String addr, String startTime, String endTime) throws ServiceException;

    /**
     * 获取所有设备信息（坐标）暂时不用
     * @author lxq
     * @DATE 2017/11/14
     * @return
     */
    List<DyEquipment> getEquipments() throws ServiceException;


    /**
     * 获取大冶所有气象设备
     * @author lxq
     * @DATE 2017/11/14
     * @return
     * @throws ServiceException
     */
    List<DyEquipment> getEquipmentList() throws ServiceException;

    /**
     * 获取某一设备详细信息和实时数据
     * @author lxq
     * @DATE 2017/11/14
     * @param addr
     * @return
     */
    Map<String,Object> getEquipmentInfo(String addr) throws ServiceException;

    /**
     * 查询所有设备数据
     * @author lxq
     * @DATE 2018/1/16
     * @return
     */
    List<DEquipmentParameter> getEquipmentParameters(String cityName,String postCode);
}
