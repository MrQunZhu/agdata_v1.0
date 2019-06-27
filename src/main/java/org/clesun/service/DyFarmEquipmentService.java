package org.clesun.service;

import org.clesun.entity.DyFarmEquipment;
import org.clesun.exception.ServiceException;

import java.util.List;

/**
 * Created by clesun on 2017/5/17.
 */
public interface DyFarmEquipmentService extends ICoreService<DyFarmEquipment, Long> {
    int insertAll(List<DyFarmEquipment> list) throws ServiceException;
}
