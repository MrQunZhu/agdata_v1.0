package org.clesun.service.impl;

import org.clesun.dao.DicSysMapper;
import org.clesun.entity.Compositor;
import org.clesun.entity.DicSys;
import org.clesun.entity.DicSysExample;
import org.clesun.entity.Filtration;
import org.clesun.exception.ServiceException;
import org.clesun.service.IDicSysService;
import org.clesun.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
public class DicSysServiceImpl implements IDicSysService{
    @Autowired
    private DicSysMapper baseMapper;

    @Override
    public int deleteById(Long id) throws ServiceException {


        try {
            return baseMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }


    }

    @Override
    public List<DicSys> findAll() throws ServiceException {
        try {
            DicSysExample example = new DicSysExample();
            return baseMapper.selectByExample(example);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }


    @Override
    public DicSys getById(Long id) throws ServiceException {
        try {
            return baseMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int insert(DicSys o) throws ServiceException {
        try {
            return baseMapper.insertSelective(o);
        } catch (DuplicateKeyException e){
            throw new ServiceException("data already exsist!!!");

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Pagination<DicSys> listByPageInfo(Pagination<DicSys> page)	throws ServiceException {

        DicSysExample example = new DicSysExample();
        try {
            if (page.getFiltrations() != null && page.getFiltrations().size() > 0) {
                DicSysExample.Criteria criteria = example.createCriteria();
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
                example.setOrderByClause("dic_id ");
            }

            page.setData(baseMapper.selectByExample(example));

        } catch (Exception e) {
            throw new ServiceException(e);
        }
        return page;
    }

    @Override
    public int update(DicSys o) throws ServiceException {

        try {

            return baseMapper.updateByPrimaryKeySelective(o);
        } catch (DuplicateKeyException e){
            throw new ServiceException("data already exsist!!!");
        }catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
