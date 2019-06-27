package org.clesun.web;

import org.clesun.entity.WsResult;
import org.clesun.service.IDFarmService;
import org.clesun.utils.ExcelImportUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by clesun on 2017/11/13.
 */
@RestController
@RequestMapping("/excel")
public class ExcelController<T> extends BaseAction  {
    @Autowired
    private IDFarmService farmService;

    /**
     * 导入企业excel表格数据
     * @author lxq
     * @DATE 2017/11/18
     * @param file
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/batchImport",method = RequestMethod.POST)
    public Object batchImportUserKnowledge(@RequestParam(value="filename") MultipartFile file,
                                           HttpServletRequest request) throws IOException {
        WsResult result = null;
        String url = request.getContextPath();
        try {
            //获取文件名
            String fileName=file.getOriginalFilename();
            long size=file.getSize();
            if(file==null){//判断文件是否为空
                result = new WsResult("-1","文件不能为空！");
            }else if(!ExcelImportUtils.validateExcel(fileName)){//验证文件名是否合格
                result = new WsResult("-1","文件必须是excel格式！");
            }else if(StringUtils.isEmpty(fileName) || size==0){//进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）
                result = new WsResult("-1","文件不能为空！");
            }else {
                //批量导入
                String message = farmService.batchImport(fileName,file,url);
                result = new WsResult("success",message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new WsResult("fail",e.getMessage());
        }
        return result;
    }

    /**
     * 导入价格excel表格数据
     * @author lxq
     * @DATE 2017/11/18
     * @param file
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/batchImportPrice",method = RequestMethod.POST)
    public Object batchImportPrice(@RequestParam(value="filename") MultipartFile file,
                                           HttpServletRequest request) throws IOException {
        WsResult result = null;
        String url = request.getContextPath();
        try {
            //获取文件名
            String fileName=file.getOriginalFilename();
            long size=file.getSize();
            if(file==null){//判断文件是否为空
                result = new WsResult("-1","文件不能为空！");
            }else if(!ExcelImportUtils.validateExcel(fileName)){//验证文件名是否合格
                result = new WsResult("-1","文件必须是excel格式！");
            }else if(StringUtils.isEmpty(fileName) || size==0){//进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）
                result = new WsResult("-1","文件不能为空！");
            }else {
                //批量导入数据
                String message = farmService.batchImportPrice(fileName,file,url);
                result = new WsResult("success",message);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new WsResult("fail",e.getMessage());
        }
        return result;
    }

    /**
     * 农场数据导出
     * @author lxq
     * @DATE 2017/11/20
     * @param response
     * @return
     */
    @RequestMapping(value = "/farmDerivation",method = RequestMethod.GET)
    public Object derivationFarm(HttpServletResponse response){
        response.setContentType("octets/stream");
        response.addHeader("Content-Disposition", "attachment;filename=farm.xls");
        WsResult result = null;
        String data = "";
        String[] farm = new String[]{"序号", "企业名称", "负责人", "法人姓名", "地址", "邮政编码", "手机", "座机",
                "电子邮箱", "营业执照号", "注册资金", "成立时间", "面积(亩)", "企业类型(种植/畜牧/水产/加工)",
                "企业种类（大户/家庭农场/合作社/农业企业）", "总投资", "固定资产", "办公生活区面积(亩)",
                "生产面积(亩)", "所在地区性质"};
        OutputStream out = null;
        try {
            out = response.getOutputStream();
        	data = farmService.exportFarmData(farm,out);
            out.close();
        	result = new WsResult("success",data);
        } catch (Exception e) {
            e.printStackTrace();
            result = new WsResult("fail",e.getMessage());
        }
        return result;
    }

    /**
     * 产品数据导出
     * @author lxq
     * @DATE 2017/11/20
     * @param response
     * @return
     */
    @RequestMapping(value = "/productDerivation",method = RequestMethod.GET)
    public Object derivationProduct(HttpServletResponse response){
        response.setContentType("octets/stream");
        response.addHeader("Content-Disposition", "attachment;filename=product.xls");
        WsResult result = null;
        String data = "";
        String[] product = new String[]{"序号", "产品种类", "企业名称", "产品名称", "价格", "总产量", "成交量", "价格发布时间",
                "成交时间(年/月/日)", "产地"};
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            data = farmService.exportProductData(product,out);
            out.close();
            result = new WsResult("success",data);
        } catch (Exception e) {
            e.printStackTrace();
            result = new WsResult("fail",e.getMessage());
        }
        return result;
    }

}
