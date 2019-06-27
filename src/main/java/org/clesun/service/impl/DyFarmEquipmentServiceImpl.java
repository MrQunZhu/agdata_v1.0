package org.clesun.service.impl;

import org.clesun.dao.DyFarmEquipmentMapper;
import org.clesun.entity.Compositor;
import org.clesun.entity.DyFarmEquipment;
import org.clesun.entity.DyFarmEquipmentExample;
import org.clesun.entity.Filtration;
import org.clesun.exception.ServiceException;
import org.clesun.service.DyFarmEquipmentService;
import org.clesun.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by clesun on 2017/5/17.
 */
@SuppressWarnings("ALL")
@Service
public class DyFarmEquipmentServiceImpl implements DyFarmEquipmentService {
    @Autowired
    private DyFarmEquipmentMapper baseMapper;

    @Override
    public int deleteById(Long id) throws ServiceException {


        try {
            return baseMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }


    }

    @Override
    public List<DyFarmEquipment> findAll() throws ServiceException {
        try {
            DyFarmEquipmentExample example = new DyFarmEquipmentExample();
            return baseMapper.selectByExample(example);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }


    @Override
    public DyFarmEquipment getById(Long id) throws ServiceException {
        try {
            return baseMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int insert(DyFarmEquipment o) throws ServiceException {
        try {
            return baseMapper.insertSelective(o);
        } catch (DuplicateKeyException e){
            throw new ServiceException("data already exsist!!!");

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Pagination<DyFarmEquipment> listByPageInfo(Pagination<DyFarmEquipment> page)	throws ServiceException {

        DyFarmEquipmentExample example = new DyFarmEquipmentExample();
        try {
            if (page.getFiltrations() != null && page.getFiltrations().size() > 0) {
                DyFarmEquipmentExample.Criteria criteria = example.createCriteria();
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
                example.setOrderByClause("farm_equipment_id");
            }

            page.setData(baseMapper.selectByExample(example));

        } catch (Exception e) {
            throw new ServiceException(e);
        }
        return page;
    }

    @Override
    public int update(DyFarmEquipment o) throws ServiceException {

        try {

            return baseMapper.updateByPrimaryKeySelective(o);
        } catch (DuplicateKeyException e){
            throw new ServiceException("data already exsist!!!");
        }catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int insertAll(List<DyFarmEquipment> list) throws ServiceException {
        return baseMapper.farmEquipmentAdd(list);
    }
}
