package org.clesun.service.impl;

import org.clesun.dao.DFarmMapper;
import org.clesun.dao.DProductMapper;
import org.clesun.entity.*;
import org.clesun.exception.ServiceException;
import org.clesun.service.IDProductService;
import org.clesun.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class DProductServiceImpl implements IDProductService{
    @Autowired
    private DProductMapper baseMapper;
    @Autowired
    private DFarmMapper dFarmMapper;

    @Override
    public int deleteById(Long id) throws ServiceException {


        try {
            return baseMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }


    }

    @Override
    public List<DProduct> findAll() throws ServiceException {
        try {
            DProductExample example = new DProductExample();
            return baseMapper.selectByExample(example);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }


    @Override
    public DProduct getById(Long id) throws ServiceException {
        try {
            return baseMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int insert(DProduct o) throws ServiceException {
        try {
            //针对添加进行优化
            //1. 设置product_type
            if("".equals(o.getProductType()) || null == o.getProductType()){ //这层判断是为了防止自定义添加数据被覆盖
                //如果确定种类没有及填写数据之后根据填写的种类信息进行补充
                if(!"".equals(o.getProductParentId()) && null != o.getProductParentId()){
                    Long productType = o.getProductParentId();
                    o.setProductType(Integer.parseInt(productType.toString()));
                }else{
                    throw new ServiceException("没有选择产品种类");
                }
            }
            //2. 根据农场信息设置省市县
            if("".equals(o.getCity()) || null == o.getCity()){ //这层判断是为了防止自定义添加数据被覆盖
                if(!"".equals(o.getFarmId()) && null != o.getFarmId()){ //如果确定城市没有自定义数据，则这里通过选择的农场信息进行补充
                    DFarm farm = dFarmMapper.selectByPrimaryKey(o.getFarmId());
                    o.setProvince(farm.getFarmProvince());
                    o.setCity(farm.getFarmCity());
                    o.setCounty(farm.getFarmCounty());
                }else{
                    throw new ServiceException("没有选择产品所属农场");
                }
            }

            //3. 根据销售时间设置年月日
            if(!"".equals(o.getMonth()) || null == o.getMonth()){  //这层判断为了防止自定义添加数据被覆盖
                if(null != o.getSoldTime()){ //如果确定没有数据，则通过出售时间进行补充填写
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    String dfdate = df.format(o.getSoldTime());
                    String[] ymd = dfdate.split("-");
                    o.setYear(ymd[0]);
                    o.setMonth(ymd[1]);
                    o.setDay(ymd[2]);
                }
            }
            return baseMapper.insertSelective(o);
        } catch (DuplicateKeyException e){
            throw new ServiceException("data already exsist!!!");

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Pagination<DProduct> listByPageInfo(Pagination<DProduct> page)	throws ServiceException {

        DProductExample example = new DProductExample();
        try {
            if (page.getFiltrations() != null && page.getFiltrations().size() > 0) {
                DProductExample.Criteria criteria = example.createCriteria();
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
                example.setOrderByClause("product_id desc");
            }

            page.setData(baseMapper.selectByExample(example));

        } catch (Exception e) {
            throw new ServiceException(e);
        }
        return page;
    }

    @Override
    public int update(DProduct o) throws ServiceException {

        try {

            return baseMapper.updateByPrimaryKeySelective(o);
        } catch (DuplicateKeyException e){
            throw new ServiceException("data already exsist!!!");
        }catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * 批量删除产品数据
     * @param ids
     * @return
     * @author lxq
     * @DATE 2018/1/4
     */
    @Override
    public int batchDelete(String[] ids) throws ServiceException {
        int result = 0;
        try {
            DProductExample example = new DProductExample();
            List<Long> productIds = new ArrayList<>();
            for (int i = 0; i < ids.length; i++) {
                productIds.add(Long.parseLong(ids[i]));
            }
            example.createCriteria().andProductIdIn(productIds);
            result = baseMapper.deleteByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
