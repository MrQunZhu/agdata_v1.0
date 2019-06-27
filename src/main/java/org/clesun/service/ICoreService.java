package org.clesun.service;


import org.clesun.exception.ServiceException;
import org.clesun.utils.Pagination;

import java.util.List;

/**
 * Created by clesun on 2017/5/17.
 */
public interface ICoreService<T,K>{
    T getById(K id) throws org.clesun.exception.ServiceException;
    List<T> findAll() throws org.clesun.exception.ServiceException;
    Pagination<T> listByPageInfo(Pagination<T> page) throws ServiceException;
    int deleteById(K id) throws org.clesun.exception.ServiceException;

    int insert(T o) throws ServiceException;
    int update(T o) throws ServiceException;
}
