package org.clesun.service;

import org.clesun.entity.DyXzData;
import org.clesun.exception.ServiceException;

import java.util.Map;

/**
 * Created by clesun on 2017/5/17.
 */
public interface DyXzDataService extends ICoreService<DyXzData, Long> {
    Map<String,Object> getXzData(String cityName,String startTime, String endTime) throws ServiceException;
}
