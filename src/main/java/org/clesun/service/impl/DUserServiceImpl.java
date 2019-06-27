package org.clesun.service.impl;

import org.clesun.dao.DUserMapper;
import org.clesun.entity.Compositor;
import org.clesun.entity.DUser;
import org.clesun.entity.DUserExample;
import org.clesun.entity.Filtration;
import org.clesun.exception.ServiceException;
import org.clesun.service.IDUserService;
import org.clesun.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class DUserServiceImpl implements IDUserService {
    @Autowired
    private DUserMapper baseMapper;

    @Override
    public int deleteById(Long id) throws ServiceException {


        try {
            return baseMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }


    }

    @Override
    public List<DUser> findAll() throws ServiceException {
        try {
            DUserExample example = new DUserExample();
            return baseMapper.selectByExample(example);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }


    @Override
    public DUser getById(Long id) throws ServiceException {
        try {
            return baseMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int insert(DUser o) throws ServiceException {
        try {
            if("".equals(o.getCreateTime()) || null == o.getCreateTime()){
                o.setCreateTime(new Date(System.currentTimeMillis()));
            }
            return baseMapper.insertSelective(o);
        } catch (DuplicateKeyException e){
            throw new ServiceException("data already exsist!!!");

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Pagination<DUser> listByPageInfo(Pagination<DUser> page)	throws ServiceException {

        DUserExample example = new DUserExample();
        try {
            if (page.getFiltrations() != null && page.getFiltrations().size() > 0) {
                DUserExample.Criteria criteria = example.createCriteria();
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
                example.setOrderByClause("user_id desc");
            }

            page.setData(baseMapper.selectByExample(example));

        } catch (Exception e) {
            throw new ServiceException(e);
        }
        return page;
    }

    @Override
    public int update(DUser o) throws ServiceException {

        try {

            return baseMapper.updateByPrimaryKeySelective(o);
        } catch (DuplicateKeyException e){
            throw new ServiceException("data already exsist!!!");
        }catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * 批量删除用户数据
     * @param ids
     * @return
     * @author lxq
     * @DATE 2018/1/4
     */
    @Override
    public int batchDelete(String[] ids) throws ServiceException {
        int result = 0;
        try {
            DUserExample example = new DUserExample();
            List<Long> userIds = new ArrayList<>();
            for (int i = 0; i < ids.length; i++) {
                userIds.add(Long.parseLong(ids[i]));
            }
            example.createCriteria().andUserIdIn(userIds);
            result = baseMapper.deleteByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
