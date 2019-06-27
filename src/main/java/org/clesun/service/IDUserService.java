package org.clesun.service;

import org.clesun.entity.DUser;
import org.clesun.exception.ServiceException;

public interface IDUserService extends ICoreService<DUser,Long> {

    /**
     * 批量删除用户数据
     * @author lxq
     * @DATE 2018/1/4
     * @param ids
     * @return
     * @throws ServiceException
     */
    int batchDelete(String[] ids) throws ServiceException;
}
