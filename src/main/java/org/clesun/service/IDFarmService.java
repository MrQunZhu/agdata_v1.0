package org.clesun.service;

import org.clesun.entity.DFarm;
import org.clesun.exception.ServiceException;
import org.springframework.web.multipart.MultipartFile;

import java.io.OutputStream;
import java.util.List;

public interface IDFarmService extends ICoreService<DFarm,Long> {

    /**
     * 上传企业excel文件到临时目录后并开始解析
     * @author lxq
     * @DATE 2017/11/15
     * @param fileName
     * @param mfile
     * @return
     */
    public String batchImport(String fileName, MultipartFile mfile,String url);

    /**
     * 上传价格excel文件到临时目录后并开始解析
     * @author lxq
     * @DATE 2017/11/15
     * @param fileName
     * @param mfile
     * @return
     */
    public String batchImportPrice(String fileName, MultipartFile mfile,String url);

    /**
     * 导出农场数据
     * @author lxq
     * @DATE 2017/11/18
     */
    String exportFarmData(String[] heads, OutputStream out);

    /**
     * 导出产品数据
     * @author lxq
     * @DATE 2017/11/18
     */
    String exportProductData(String[] heads, OutputStream out);

    /**
     * 批量删除农场数据
     * @author lxq
     * @DATE 2018/1/4
     * @param ids
     * @return
     */
    int batchDelete(String[] ids) throws ServiceException;


    List<DFarm> getNotInRangeFarmList(String province, String city);
}
