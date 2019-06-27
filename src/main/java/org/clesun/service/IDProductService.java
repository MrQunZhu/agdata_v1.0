package org.clesun.service;

import org.clesun.entity.DProduct;
import org.clesun.exception.ServiceException;

public interface IDProductService extends ICoreService<DProduct,Long> {

    /**
     * 批量删除产品信息
     * @author lxq
     * @DATE 2018/1/4
     * @param ids
     * @return
     * @throws ServiceException
     */
    int batchDelete(String[] ids) throws ServiceException;
}
