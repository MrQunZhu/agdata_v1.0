package org.clesun.service.impl;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.clesun.dao.DFarmMapper;
import org.clesun.dao.DProductMapper;
import org.clesun.dao.DicSysMapper;
import org.clesun.entity.*;
import org.clesun.exception.ServiceException;
import org.clesun.service.IDFarmService;
import org.clesun.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@SuppressWarnings("ALL")
@Service
public class DFarmServiceImpl implements IDFarmService{
    @Autowired
    private DFarmMapper baseMapper;

    @Autowired
    private DProductMapper productMapper;

    @Autowired
    private DicSysMapper dicSysMapper;

    @Override
    public int deleteById(Long id) throws ServiceException {

        try {
            return baseMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public List<DFarm> findAll() throws ServiceException {
        try {
            DFarmExample example = new DFarmExample();
            return baseMapper.selectByExample(example);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }


    @Override
    public DFarm getById(Long id) throws ServiceException {
        try {
            return baseMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int insert(DFarm o) throws ServiceException {
        try {
            //1. 根据填写地址补充地址，经纬度信息
            if(!"".equals(o.getFarmAddress()) && null != o.getFarmAddress()){
                AdressDetailEntity address = GeoUtil.getAdress(o.getFarmAddress());
                o.setFarmProvince(address.getProvince());
                o.setFarmCity(address.getCity());
                o.setFarmCounty(address.getCounty());
                o.setFarmAddress(address.getAddress());
                o.setLocationLng(Double.parseDouble(address.getLng()));
                o.setLocationLat(Double.parseDouble(address.getLat()));
            }else{
                throw new ServiceException("没有填写农场地址");
            }
            return baseMapper.insertSelective(o);
        } catch (DuplicateKeyException e){
            throw new ServiceException("data already exsist!!!");

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Pagination<DFarm> listByPageInfo(Pagination<DFarm> page)	throws ServiceException {
        DFarmExample example = new DFarmExample();
        try {
            if (page.getFiltrations() != null && page.getFiltrations().size() > 0) {
                DFarmExample.Criteria criteria = example.createCriteria();
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
                example.setOrderByClause("business_code desc");
            }

            page.setData(baseMapper.selectByExample(example));

        } catch (Exception e) {
            throw new ServiceException(e);
        }
        return page;
    }

    @Override
    public int update(DFarm o) throws ServiceException {

        try {

            return baseMapper.updateByPrimaryKeySelective(o);
        } catch (DuplicateKeyException e){
            throw new ServiceException("data already exsist!!!");
        }catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    /**
     * 上传excel文件到临时目录后并开始解析
     * @param fileName
     * @param mfile
     * @return
     * @author lxq
     * @DATE 2017/11/13
     */
    @Override
    public String batchImport(String fileName, MultipartFile mfile,String url) {
        String result = "导入出错!";
        File uploadDir = new  File(url);
        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        //新建一个文件
        File tempFile = new File(url + System.currentTimeMillis() + ".xlsx");
        //初始化输入流
        InputStream is = null;
        try{
            //将上传的文件写入新建的文件中
            mfile.transferTo(tempFile);

            //根据新建的文件实例化输入流
            is = new FileInputStream(tempFile);

            //根据版本选择创建Workbook的方式
            Workbook wb = null;
            //根据文件名判断文件是2003版本还是2007版本
            if(ExcelImportUtils.isExcel2007(fileName)){
                wb = new XSSFWorkbook(is);
            }else{
                wb = new HSSFWorkbook(is);
            }
            //根据excel里面的内容读取知识库信息
            result = readExcelValue(wb,tempFile);
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            if(is !=null)
            {
                try{
                    is.close();
                }catch(IOException e){
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 上传价格excel文件到临时目录后并开始解析
     *
     * @param fileName
     * @param mfile
     * @param url
     * @return
     * @author lxq
     * @DATE 2017/11/15
     */
    @Override
    public String batchImportPrice(String fileName, MultipartFile mfile, String url) {
        String result = "导入出错!";
        File uploadDir = new  File(url);
        //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        //新建一个文件
        File tempFile = new File(url + System.currentTimeMillis() + ".xlsx");
        //初始化输入流
        InputStream is = null;
        try{
            //将上传的文件写入新建的文件中
            mfile.transferTo(tempFile);

            //根据新建的文件实例化输入流
            is = new FileInputStream(tempFile);

            //根据版本选择创建Workbook的方式
            Workbook wb = null;
            //根据文件名判断文件是2003版本还是2007版本
            if(ExcelImportUtils.isExcel2007(fileName)){
                wb = new XSSFWorkbook(is);
            }else{
                wb = new HSSFWorkbook(is);
            }
            //根据excel里面的内容读取知识库信息
            result = readPriceExcelValue(wb,tempFile);
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            if(is !=null)
            {
                try{
                    is.close();
                }catch(IOException e){
                    is = null;
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 解析企业Excel里面的数据
     * @param wb
     * @param tempFile
     * @return
     * @author lxq
     * @DATE 2017/11/13
     */
    public String readExcelValue(Workbook wb, File tempFile) {
        //错误信息接收器
        String errorMsg = "";
        String result = "";
        String br = "<br/>";
        String failData = "";
        Calendar calendar = GregorianCalendar.getInstance();
        //得到Excel shell个数
        int sheets = wb.getNumberOfSheets();
        if(sheets>0){
            int successNums = 0;
            int updateNums = 0;
            //循环sheet
            for (int s = 0; s < sheets; s++) {
                //得到第一个sheet
                Sheet sheet=wb.getSheetAt(s);
                //得到Excel的行数
                int totalRows=sheet.getPhysicalNumberOfRows();
                //总列数
                int totalCells = 0;
                //得到Excel的列数(前提是有行数)，从第三行算起
                if(totalRows>=6 && sheet.getRow(1) != null){
                    totalCells=sheet.getRow(1).getPhysicalNumberOfCells();
                }
                List<DFarm> farmList=new ArrayList<DFarm>();
                DFarm farm = null;

                //循环Excel行数,从第三行开始。标题不入库
                int failNums = 0;
                //从第六行开始循环获取数据
                for(int r=5;r<totalRows;r++){
                    try {
                        Row row = sheet.getRow(r);
                        //验证行是否为空
                        if(CheckRowNull(row,totalCells)>30){
                            continue;
                        }
                        /*if (row == null || row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_BLANK){
                            continue;
                        }*/
                        farm = new DFarm();
                        List<DicSys> bussiness = null;
                        List<DicSys> farmType = null;
                        List<DicSys> sysList = null;
                        //从第二列开始循环Excel(组装一行数据)
                        for(int c = 1; c <totalCells; c++){
                            try {
                                Cell cell = row.getCell(c);
                                if (null != cell){
                                    String data = null;
                                    Date date =null;
                                    //判断单元格数据类型
                                    if(cell.getCellType()==0 && HSSFDateUtil.isCellDateFormatted(cell)){
                                        if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                                                .getBuiltinFormat("yyyy-MM-dd")) {
                                            date = cell.getDateCellValue();
                                        }else{
                                            date = cell.getDateCellValue();
                                        }
                                        // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                                    }else if(cell.getCellStyle().getDataFormat() == 31){
                                        double value = cell.getNumericCellValue();
                                        date  = DateUtil.getJavaDate(value);
                                    }else{
                                        cell.setCellType(Cell.CELL_TYPE_STRING);
                                        data = cell.getStringCellValue().trim();
                                    }
                                    if(c == 1){//企业名称
                                        farm.setFarmName(data);
                                    }else if(c == 2){//企业类型
                                        //判断数据是否为空
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            DicSysExample dicSysExample = new DicSysExample();
                                            //查询类型对应的id
                                            dicSysExample.createCriteria().andDicValueEqualTo(data);
                                            bussiness = dicSysMapper.selectByExample(dicSysExample);
                                            if(bussiness != null && bussiness.size()>0){
                                                farm.setBusinessScop(data);
                                                farm.setBusinessCode(bussiness.get(0).getDicId());
                                            }else{
                                                farm.setBusinessScop(data);
                                                //errorMsg += br+"第"+(r+1)+"行 ，第"+ (c+1) +"列企业类型未按规定填写，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 3){//企业性质
                                        //判断数据是否为空
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            DicSysExample dicSysExample = new DicSysExample();
                                            //查询类型对应的id
                                            dicSysExample.createCriteria().andDicValueEqualTo(data);
                                            farmType = dicSysMapper.selectByExample(dicSysExample);
                                            if(farmType != null && farmType.size()>0){
                                                farm.setFarmType(data);
                                                farm.setFarmTypeId(farmType.get(0).getDicId());
                                            }else{
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列企业性质未按规定填写，请仔细检查！";
                                            }
                                        }else{
                                            farm.setFarmType("其他");
                                            farm.setFarmTypeId(11L);
                                        }
                                    }
                                    else if(c == 4){//负责人
                                        farm.setManageName(data);
                                    }else if(c == 5){//法人
                                        farm.setLegalName(data);
                                    }else if(c == 6){//座机
                                        farm.setTelephoneNo(data);
                                    }else if(c == 7){//手机
                                         if(VerificationUtil.isMobile(data)){
                                            farm.setPhoneNo(data);
                                        }else{
                                            errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列手机格式有问题，请仔细检查！";
                                        }
                                    }else if(c == 8){//企业地址
                                        farm.setFarmAddress(data);
                                    }else if(c == 9){//邮政编码
                                         if(VerificationUtil.isPostCode(data)){
                                            farm.setPostalCode(data);
                                        }else {
                                            errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列邮政编码格式有问题，请仔细检查！";
                                        }
                                    }else if(c == 10){//电子邮箱
                                        if(VerificationUtil.isEmail(data)){
                                            farm.setEmail(data);
                                        }else {
                                            errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列电子邮箱格式有问题，请仔细检查！";
                                        }
                                    }else if(c == 11){//营业执照号
                                        farm.setBusinessLicenseCode(data);
                                    }
                                    else if(c == 12){//注册资金
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            try {
                                                farm.setRegisteredCapital(Double.parseDouble(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列注册资金不是数字，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 13){//注册时间
                                        if(date!=null && !StringUtils.isEmpty(data)){
                                            farm.setRegisteredTime(date);
                                        }else{
                                            errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列注册日期格式不正确，请仔细检查！";
                                        }
                                    }else if(c == 14){//总投资
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            try {
                                                farm.setTotalInvestment(Double.parseDouble(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列总投资不是数字，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 15){//固定资产
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            try {
                                                farm.setFixedAssets(Double.parseDouble(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列固定资产不是数字，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 16){//总面积
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            try {
                                                farm.setTotalArea(Double.parseDouble(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列总面积不是数字，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 17){//办公生活面积
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            try {
                                                farm.setOfficeArea(Double.parseDouble(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列办公生活面积不是数字，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 18){//生产面积
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            try {
                                                farm.setProductionArea(Double.parseDouble(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列生产面积不是数字，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 19){//所在地区性质
                                        farm.setRegionalNature(data);
                                    }else if(c == 20){//产品种类(种植)
                                        if(data !=null && !StringUtils.isEmpty(data)){
                                            DicSysExample dicSysExample = new DicSysExample();
                                            //查询产品种类对应的id
                                            dicSysExample.createCriteria().andDicValueEqualTo(data);
                                            sysList = dicSysMapper.selectByExample(dicSysExample);
                                            if(sysList!=null && sysList.size()>0){
                                                farm.setProductParentId(sysList.get(0).getDicId());
                                                farm.setProductParentValue(data);
                                            }else{
                                                farm.setProductParentValue(data);
                                                //errorMsg += br+"第"+(r+1)+"行 ，第"+ (c+1) +"列数据有问题，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 21){//产品名称(种植)
                                        if(data !=null && !StringUtils.isEmpty(data)){
                                            farm.setProductName(data);
                                        }
                                    }else if(c == 22){//种植面积
                                        if(data !=null && !StringUtils.isEmpty(data)){
                                            try {
                                                farm.setPlantBreedArea(Double.parseDouble(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列种植面积不是数字，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 23){//种植总产量
                                        if(data !=null && !StringUtils.isEmpty(data)){
                                            try {
                                                farm.setTotalYield(Double.parseDouble(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列种植总产量不是数字，请仔细检查！";
                                            }
                                        }
                                    }
                                    else if(c == 24){//价格
                                        if(data !=null && !StringUtils.isEmpty(data)){
                                            try {
                                                farm.setProductPrice(Double.parseDouble(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列价格不是数字，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 25){//产品种类(水产)
                                        if(data !=null && !StringUtils.isEmpty(data)){
                                            DicSysExample dicSysExample = new DicSysExample();
                                            //查询产品种类对应的id
                                            dicSysExample.createCriteria().andDicValueEqualTo(data);
                                            sysList = dicSysMapper.selectByExample(dicSysExample);
                                            if(sysList!=null && sysList.size()>0){
                                                farm.setProductParentId(sysList.get(0).getDicId());
                                                farm.setProductParentValue(data);
                                            }else{
                                                farm.setProductParentValue(data);
                                                //errorMsg += br+"第"+(r+1)+"行 ，第"+ (c+1) +"列数据有问题，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 26){//产品名称(水产)
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            farm.setProductName(data);
                                        }
                                    }else if(c == 27){//水产面积
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            try {
                                                farm.setPlantBreedArea(Double.parseDouble(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列养殖面积不是数字，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 28){//水产总产量
                                        if(data !=null && !StringUtils.isEmpty(data)){
                                            try {
                                                farm.setTotalYield(Double.parseDouble(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列养殖产量不是数字，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 29){//是否为龙头企业
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            farm.setIsLeadingEnterprise(data);
                                        }
                                    }else if(c == 30){//是否被耍
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            farm.setIsBrush(data);
                                        }
                                    }else if(c == 31){//是否停产
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            farm.setIsStop(data);
                                        }
                                    }else if(c == 32){//级别
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            farm.setEnterpriseLevel(data);
                                        }
                                    }else if(c == 33){//畜牧养殖品种
                                        farm.setBreedProductName(data);
                                    }else if(c == 34){//存栏数
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            try {
                                                farm.setBreedingStock(Integer.parseInt(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列存栏量不是数字，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 35){//公畜禽(头只)
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            try {
                                                farm.setMaleNum(Integer.parseInt(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列公畜禽不是数字，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 36){//母畜禽(头只)
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            try {
                                                farm.setFemaleNum(Integer.parseInt(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列母畜禽不是数字，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 37){//上年出栏情况
                                        farm.setOutColumn(data);
                                    }else if(c == 38){//是否办理环评手续
                                        farm.setIsEnvAssessment(data);
                                    }else if(c == 39){//养殖场粪污处理设施及资源化利用现状
                                        farm.setFacilitiesResources(data);
                                    }else if(c == 40){//粪污处理设施改造升级项目名称
                                        farm.setProjectName(data);
                                    }else if(c == 41){//改造所需资金结算(万元)
                                        if(data != null && !StringUtils.isEmpty(data)){
                                            try {
                                                farm.setImprovementCapital(Double.parseDouble(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行 ，第"+ (c+1) +"列改造资金不是数字，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 42){//备注
                                        farm.setFarmRemark(data);
                                    }
                                }
                            } catch (Exception e) {
                                failNums++;
                                errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行，第 "+ (c+1) +"列数据有问题，请仔细检查！";
                                continue;
                            }
                        }

                        //农场数据
                        DFarmExample farmExample = new DFarmExample();
                        DFarmExample farmLegalNameExample = new DFarmExample();
                        //查询当前农场是否存在
                        List<DFarm> farms = null;
                        //if(farm.getFarmName() != null && !StringUtils.isEmpty(farm.getFarmName())){
                            farmExample.createCriteria().andFarmNameEqualTo(farm.getFarmName())
                                    .andManageNameEqualTo(farm.getManageName())
                                    .andLegalNameEqualTo(farm.getLegalName());
                            farms = baseMapper.selectByExample(farmExample);
                        //}
                        /*List<DFarm> farmLegalName = null;
                        if(farm.getLegalName() != null && !StringUtils.isEmpty(farm.getLegalName())){
                            farmLegalNameExample.createCriteria().andLegalNameEqualTo(farm.getLegalName());
                            farmLegalName = baseMapper.selectByExample(farmLegalNameExample);
                        }*/
                        //判断农场是否存在防止重复录入相同的农场
                        if((farms==null || farms.size()<=0)){
                            AdressDetailEntity adressDetail = new AdressDetailEntity();
                            adressDetail = GeoUtil.getAdress(farm.getFarmAddress().trim());
                            farm.setFarmProvince(adressDetail.getProvince());
                            farm.setFarmCity(adressDetail.getCity());
                            farm.setFarmCounty(adressDetail.getCounty());
                            farm.setFarmTown(adressDetail.getTown());
                            farm.setFarmSubdistrict(adressDetail.getSubdistrict());
                            farm.setCreateTime(new Date());
                            farm.setScopeJson(farm.getProductParentValue());
                            if(adressDetail.getLat() != null){
                                farm.setLocationLat(Double.parseDouble(adressDetail.getLat()));
                            }
                            if(adressDetail.getLng() != null){
                                farm.setLocationLng(Double.parseDouble(adressDetail.getLng()));
                            }
                            //保存农场信息
                            int nums = baseMapper.insert(farm);
                            successNums++;
                        }else {//农场存在
                            //产品种类存在的情况下更新农场中scopJson值，否则不更新
                            if(sysList!=null && sysList.size()>0){
                                //判断进行拼接scopJson值
                                String scopJson = farms.get(0).getScopeJson();
                                String scop = farm.getProductParentValue();
                                if(!scopJson.contains(scop)){
                                    scopJson +=","+scop;
                                }
                                farm.setScopeJson(scopJson);
                            }
                            //if(farms != null && farms.size() > 0){
                                farm.setFarmId(farms.get(0).getFarmId());
                            /*}else if(farmLegalName != null && farmLegalName.size() > 0){
                                farm.setFarmId(farmLegalName.get(0).getFarmId());
                            }*/
                            //农场存在则更新一次
                            baseMapper.updateByPrimaryKeySelective(farm);
                            updateNums++;
                        }

                    } catch (Exception e) {
                        failNums++;
                        errorMsg += br+"第"+(s+1)+"shell,第"+(r+1)+"行数据有问题，请仔细检查！";
                    }

                }
            }
            result = "共成功导入" + successNums + "条数据,更新" + updateNums + "条数据";
        }else {
            errorMsg = "文档内容为空";
        }

        //删除上传的临时文件
        if(tempFile.exists()){
            tempFile.delete();
        }

        if(StringUtils.isEmpty(errorMsg)){
            return result;
        }else {
            return result+errorMsg;
        }
    }

    /**
     * 解析价格Excel里面的数据
     * @param wb
     * @param tempFile
     * @return
     * @author lxq
     * @DATE 2017/11/13
     */
    public String readPriceExcelValue(Workbook wb, File tempFile) {
        //错误信息接收器
        String errorMsg = "";
        String result = "";
        String br = "<br/>";
        String failData = "";
        Calendar calendar = GregorianCalendar.getInstance();
        //得到Excel shell个数
        int sheets = wb.getNumberOfSheets();
        if(sheets>0){
            int successNums = 0;
            for (int s = 0; s < sheets; s++) {
                //得到第一个sheet
                Sheet sheet=wb.getSheetAt(s);
                //得到Excel的行数
                int totalRows=sheet.getPhysicalNumberOfRows();
                //总列数
                int totalCells = 0;
                //得到Excel的列数(前提是有行数)，从第三行算起
                if(totalRows>=2 && sheet.getRow(1) != null){
                    totalCells=sheet.getRow(1).getPhysicalNumberOfCells();
                }
                List<DProduct> productList = new ArrayList<DProduct>();
                DProduct product = null;

                //循环Excel行数,从第三行开始。标题不入库
                int failNums = 0;
                for(int r=2;r<totalRows;r++){
                    try {
                        Row row = sheet.getRow(r);
                        if(r==14){
                            System.out.print(row);
                        }
                        //验证行是否为空
                        if(CheckRowNull(row,totalCells)>10){
                            continue;
                        }
                        /*if (row == null || row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_BLANK){
                            continue;
                        }*/
                        product = new DProduct();
                        List<DicSys> sysList = null;
                        //从第二列开始循环Excel(组装一行数据)
                        for(int c = 1; c <totalCells; c++){
                            try {
                                Cell cell = row.getCell(c);
                                //if (null != cell){
                                    String data = null;
                                    Date date =null;
                                if (null != cell) {
                                    //判断单元格数据类型
                                    if (cell.getCellType() == 0 && HSSFDateUtil.isCellDateFormatted(cell)) {
                                        if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                                                .getBuiltinFormat("yyyy-MM-dd")) {
                                            date = cell.getDateCellValue();
                                        } else {
                                            date = cell.getDateCellValue();
                                        }
                                        // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                                    } else if (cell.getCellStyle().getDataFormat() == 31) {
                                        double value = cell.getNumericCellValue();
                                        date = DateUtil.getJavaDate(value);
                                    } else {
                                        cell.setCellType(Cell.CELL_TYPE_STRING);
                                        data = cell.getStringCellValue();
                                    }
                                }
                                    if(c == 1){//产品类别
                                        DicSysExample dicSysExample = new DicSysExample();
                                        //查询产品种类对应的id
                                        dicSysExample.createCriteria().andDicValueEqualTo(data);
                                        sysList = dicSysMapper.selectByExample(dicSysExample);
                                        if(sysList!=null && sysList.size()>0){
                                            product.setProductParentValue(data);
                                            product.setProductParentId(sysList.get(0).getDicId());
                                            product.setProductType(sysList.get(0).getDicType());
                                        }else{
                                            errorMsg += br+"第"+(r+1)+"行 ，第"+ (c+1) +"列产品类别未按规定填写，请仔细检查！";
                                        }
                                    }else if(c == 2){//企业名称
                                        if(data != null){
                                            DFarmExample farmExample = new DFarmExample();
                                            farmExample.createCriteria().andFarmNameEqualTo(data);
                                            List<DFarm> farmList = baseMapper.selectByExample(farmExample);
                                            if(farmList !=null && farmList.size() > 0){
                                                product.setFarmName(data);
                                                product.setFarmId(farmList.get(0).getFarmId());
                                            }else{
                                                product.setFarmName(data);
                                                //errorMsg += br+"第"+(r+1)+"行 ，第"+ (c+1) +"列企业不存在，请仔细检查！";
                                            }
                                        }
                                    }else if(c == 3){//产品名称
                                        product.setProductName(data);
                                    }else if(c == 4){//价格
                                        try {
                                            product.setProductPrice(Double.parseDouble(data));
                                        } catch (Exception e) {
                                            errorMsg += br+"第"+(r+1)+"行 ，第"+ (c+1) +"列价格不是数字，请仔细检查！";
                                        }
                                    }else if(c == 5){//价格单位
                                        product.setPriceUnit(data);
                                    }else if(c == 6){//产量
                                        if(data != null && !"".equals(data)){
                                            try {
                                                product.setTotalYield(Double.parseDouble(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(r+1)+"行 ，第"+ (c+1) +"列产量不是数字，请仔细检查！";
                                            }
                                        }else{
                                            errorMsg += br+"第"+(r+1)+"行 ，第"+ (c+1) +"列产量不能为空，请仔细检查！";
                                        }

                                    }else if(c == 7){//产量单位
                                        product.setYieldUnit(data);
                                    }else if(c == 8){//成交量
                                        if(data != null && !"".equals(data)){
                                            try {
                                                product.setSoldQuantity(Double.parseDouble(data));
                                            } catch (Exception e) {
                                                errorMsg += br+"第"+(r+1)+"行 ，第"+ (c+1) +"列成交量不是数字，请仔细检查！";
                                            }
                                        }else{
                                            errorMsg += br+"第"+(r+1)+"行 ，第"+ (c+1) +"列成交量不能为空，请仔细检查！";
                                        }
                                    }else if(c == 9){//价格发布时间
                                        if(date != null && !"".equals(date)){
                                            product.setPriceReleaseTime(date);
                                        }else{
                                            errorMsg += br+"第"+(r+1)+"行 ，第"+ (c+1) +"列价格发布时间格式不正确，请仔细检查！";
                                        }
                                    }else if(c == 10){//成交时间
                                        if(date!=null && !"".equals(date)){
                                            product.setSoldTime(date);
                                        }else{
                                            errorMsg += br+"第"+(r+1)+"行 ，第"+ (c+1) +"列成交日期格式有问题，请仔细检查！";
                                        }
                                    }else if(c == 11){//产地
                                        product.setPlaceOrigin(data);
                                    }
                                //}
                            } catch (Exception e) {
                                e.printStackTrace();
                                failNums++;
                                errorMsg += br+"第"+(r+1)+"行，第 "+ (c+1) +"列数据有问题，请仔细检查！";
                                continue;
                            }
                        }

                        //判断表格产品数据是否完善
                        if(sysList != null && sysList.size() > 0 && product.getTotalYield() != null
                                && product.getProductPrice() != null && product.getSoldQuantity() != null
                                && product.getSoldTime() != null && product.getPriceReleaseTime() != null){
                            AdressDetailEntity adressDetail = new AdressDetailEntity();
                            adressDetail = GeoUtil.getAdress(product.getPlaceOrigin());
                            //判断通过产地是否获得行政区划的省市县
                            if(adressDetail != null){
                                product.setProvince(adressDetail.getProvince());
                                product.setCity(adressDetail.getCity());
                                product.setCounty(adressDetail.getCounty());
                            }
                            product.setCreateTime(new Date());
                            Date date = product.getSoldTime();
                            calendar.setTime(date);
                            product.setYear(String.valueOf(calendar.get(Calendar.YEAR)));
                            product.setMonth(String.valueOf(calendar.get(Calendar.MONTH)+1));
                            product.setDay(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
                            productMapper.insert(product);
                            successNums++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        failNums++;
                        errorMsg += br+"第"+(r+1)+"行数据有问题，请仔细检查！";
                    }

                }
            }

            result = "共成功导入" + successNums + "条数据";
        }else {
            errorMsg = "文档内容为空";
        }

        //删除上传的临时文件
        if(tempFile.exists()){
            tempFile.delete();
        }

        if(StringUtils.isEmpty(errorMsg)){
            return result;
        }else {
            return result+errorMsg;
        }
    }

    /**
     * 验证空单元格的个数
     * @author lxq
     * @DATE 2018/1/17
     * @param row
     * @return
     */
    private int CheckRowNull(Row row,int totalCells){
        int num = 0;
        for(int c = 1; c <totalCells; c++){
            Cell cell = row.getCell(c);
            if(cell != null){
                if(cell.getCellType() ==HSSFCell.CELL_TYPE_BLANK){
                    num++;
                }
            }else{
                num++;
            }
        }
        return num;
    }

    /**
     * 导出农场数据
     *
     * @author lxq
     * @DATE 2017/11/18
     */
    @Override
    public String exportFarmData(String[] headers, OutputStream out) {
        List<DFarm> list = null;
        try {
            DFarmExample example = new DFarmExample();
            list = baseMapper.selectByExample(example);
            //--->创建了一个excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            //--->创建了一个工作簿
            HSSFSheet sheet = wb.createSheet("企业信息");
            //--->第一个参数是指哪个单元格，第二个参数是单元格的宽度
//            sheet.setColumnWidth((short)4, 20* 256);
            // ---->有得时候你想设置统一单元格的高度，就用这个方法
            sheet.setDefaultRowHeight((short)300);

            //样式1
            HSSFCellStyle style = wb.createCellStyle(); // 样式对象
            style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
            style.setWrapText(true);   //设置是否能够换行，能够换行为true
            style.setBorderBottom((short)1);   //设置下划线，参数是黑线的宽度
            style.setBorderLeft((short)1);   //设置左边框
            style.setBorderRight((short)1);   //设置有边框
            style.setBorderTop((short)1);   //设置下边框
            //设置标题字体格式
            Font font = wb.createFont();
            //设置字体样式
            font.setFontHeightInPoints((short)12);   //--->设置字体大小
            font.setFontName("宋体");   //---》设置字体，是什么类型例如：宋体
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
            font.setItalic(false);     //--->设置是否是斜体
            style.setFont(font);     //--->将字体格式加入到style中


            //样式2
            HSSFCellStyle style2 = wb.createCellStyle(); // 样式对象
            style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
            style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
            style2.setWrapText(false);   //设置是否能够换行，能够换行为true
            style2.setBorderBottom((short)1);   //设置下划线，参数是黑线的宽度
            style2.setBorderLeft((short)1);   //设置左边框
            style2.setBorderRight((short)1);   //设置有边框
            style2.setBorderTop((short)1);   //设置下边框
            //设置标题字体格式
            Font font2 = wb.createFont();
            //设置字体样式
            font2.setFontHeightInPoints((short)12);   //--->设置字体大小
            font2.setFontName("宋体");   //---》设置字体，是什么类型例如：宋体
            font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//非粗体显示
            font2.setItalic(false);     //--->设置是否是斜体
            style2.setFont(font2);     //--->将字体格式加入到style中


            //表格第一行
            HSSFRow row = sheet.createRow(0);   //--->创建一行
            // 四个参数分别是：起始行，起始列，结束行，结束列
            //sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 15));
//            row.setHeightInPoints(25);

            //循环创建标题行
            for (int i = 0; i < headers.length; i++) {
                sheet.setColumnWidth((short)i, 20* 256);
                HSSFCell cell1 = row.createCell((short)i);   //--->创建一个单元格
                cell1.setCellStyle(style);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell1.setCellValue(text);
            }

            //循环导入数据
            for (int j = 0; j < list.size(); j++) {
                row = sheet.createRow(j+1);
                DFarm farm = list.get(j);
                for (int k = 0; k < headers.length; k++) {
                    HSSFCell cell2 = row.createCell((short)k);
                    cell2.setCellStyle(style2);
                    if(k == 0){//序号
                        cell2.setCellValue(j+1);
                    }else if(k == 1){//企业名称
                        if(farm.getFarmName()!=null){
                            cell2.setCellValue(farm.getFarmName());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 2){//负责人
                        if(farm.getManageName()!=null){
                            cell2.setCellValue(farm.getManageName());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 3){//法人
                        if(farm.getLegalName()!=null){
                            cell2.setCellValue(farm.getLegalName());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 4){//地址
                        if(farm.getFarmAddress()!=null){
                            cell2.setCellValue(farm.getFarmAddress());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 5){//邮政编码
                        if(farm.getPostalCode()!=null){
                            cell2.setCellValue(farm.getPostalCode());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 6){//手机
                        if(farm.getPhoneNo()!=null){
                            cell2.setCellValue(farm.getPhoneNo());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 7){//座机
                        if(farm.getTelephoneNo()!=null){
                            cell2.setCellValue(farm.getTelephoneNo());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 8){//电子邮箱
                        if(farm.getEmail()!=null){
                            cell2.setCellValue(farm.getEmail());
                        }else{
                            cell2.setCellValue("");
                        }
                    }
                    else if(k == 9){//营业执照号
                        if(farm.getBusinessLicenseCode()!=null){
                            cell2.setCellValue(farm.getBusinessLicenseCode());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 10){//注册资金
                        if(farm.getRegisteredCapital()!=null){
                            cell2.setCellValue(farm.getRegisteredCapital());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 11){//成立时间
                        if(farm.getRegisteredTime()!=null){
                            cell2.setCellValue(DateUtils.formatDate(farm.getRegisteredTime(),"yyyy/MM/dd"));
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 12){//面积
                        if(farm.getTotalArea()!=null){
                            cell2.setCellValue(farm.getTotalArea());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 13){//企业类型
                        if(farm.getBusinessCode()!=null){
                            cell2.setCellValue(farm.getBusinessScop());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 14){//企业性质
                        if(farm.getFarmType()!=null){
                            cell2.setCellValue(farm.getFarmType());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 15){//总投资
                        if(farm.getTotalInvestment()!=null){
                            cell2.setCellValue(farm.getTotalInvestment());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 16){//固定资产
                        if(farm.getFixedAssets()!=null){
                            cell2.setCellValue(farm.getFixedAssets());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 17){//办公生活区面积
                        if(farm.getOfficeArea()!=null){
                            cell2.setCellValue(farm.getOfficeArea());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 18){//生产面积
                        if(farm.getProductionArea()!=null){
                            cell2.setCellValue(farm.getProductionArea());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 19){//所在地区性质
                        if(farm.getRegionalNature()!=null){
                            cell2.setCellValue(farm.getRegionalNature());
                        }
                    }
                }
            }

            FileOutputStream fileOut = null;
            try{
//                fileOut = new FileOutputStream("E:\\farm.xls");
                wb.write(out);
                return "导出成功";
            }catch(Exception e){
                e.printStackTrace();
            }
            finally{
                if(fileOut != null){
                    try {
                        fileOut.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "导出失败";
    }

    /**
     * 导出产品数据
     * @author lxq
     * @DATE 2017/11/18
     */
    @Override
    public String exportProductData(String[] headers, OutputStream out) {
        List<DProduct> list = null;
        try {
            DProductExample example = new DProductExample();
            list = productMapper.selectByExample(example);
            //--->创建了一个excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            //--->创建了一个工作簿
            HSSFSheet sheet = wb.createSheet("产品信息");
            //--->单元格内容格式
            HSSFDataFormat format= wb.createDataFormat();
            //---》设置单元格宽度，因为一个单元格宽度定了那么下面多有的单元格高度都确定了所以这个方法是sheet的
            //sheet.setColumnWidth((short)3, 20* 256);
            //--->第一个参数是指哪个单元格，第二个参数是单元格的宽度
            //sheet.setColumnWidth((short)4, 20* 256);
            // ---->有得时候你想设置统一单元格的高度，就用这个方法
            sheet.setDefaultRowHeight((short)300);
            //样式1
            HSSFCellStyle style = wb.createCellStyle(); // 样式对象1
            style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
            style.setWrapText(true);   //设置是否能够换行，能够换行为true
            style.setBorderBottom((short)1);   //设置下划线，参数是黑线的宽度
            style.setBorderLeft((short)1);   //设置左边框
            style.setBorderRight((short)1);   //设置右边框
            style.setBorderTop((short)1);   //设置下边框
            //设置标题字体格式1
            Font font = wb.createFont();
            //设置字体样式1
            font.setFontHeightInPoints((short)12);   //--->设置字体大小
            font.setFontName("宋体");   //---》设置字体，是什么类型例如：宋体
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示
            font.setItalic(false);     //--->设置是否是斜体
            style.setFont(font);     //--->将字体格式加入到style中

            //样式2
            HSSFCellStyle style2 = wb.createCellStyle(); // 样式对象2
            style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
            style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
            style2.setWrapText(false);   //设置是否能够换行，能够换行为true
            style2.setBorderBottom((short)1);   //设置下划线，参数是黑线的宽度
            style2.setBorderLeft((short)1);   //设置左边框
            style2.setBorderRight((short)1);   //设置右边框
            style2.setBorderTop((short)1);   //设置下边框
            //设置标题字体格式2
            Font font2 = wb.createFont();
            //设置字体样式2
            font2.setFontHeightInPoints((short)12);   //--->设置字体大小
            font2.setFontName("宋体");   //---》设置字体，是什么类型例如：宋体
            font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);//非粗体显示
            font2.setItalic(false);     //--->设置是否是斜体
            style2.setFont(font2);     //--->将字体格式加入到style中


            //表格第一行
            HSSFRow row = sheet.createRow(0);   //--->创建一行
            // 四个参数分别是：起始行，起始列，结束行，结束列
            //sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 15));
//            row.setHeightInPoints(25);

            //循环创建标题行
            for (int i = 0; i < headers.length; i++) {
                sheet.setColumnWidth((short)i, 20* 256);
                HSSFCell cell1 = row.createCell((short)i);   //--->创建一个单元格
                cell1.setCellStyle(style);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell1.setCellValue(text);
            }

            //循环导入数据
            for (int j = 0; j < list.size(); j++) {
                row = sheet.createRow(j+1);
                DProduct product = list.get(j);
                for (int k = 0; k < headers.length; k++) {
                    HSSFCell cell2 = row.createCell((short)k);
                    cell2.setCellStyle(style2);
                    if(k == 0){//序号
                        cell2.setCellValue(j+1);
                    }else if(k == 1){//产品类别(种植/水产/畜牧/加工)
                        if(product.getProductParentValue()!=null){
                            cell2.setCellValue(product.getProductParentValue());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 2){//企业名称
                        if(product.getFarmName()!=null){
                            cell2.setCellValue(product.getFarmName());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 3){//产品名称
                        if(product.getProductName()!=null){
                            cell2.setCellValue(product.getProductName());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 4){//价格
                        if(product.getProductPrice()!=null){
                            if(product.getPriceUnit()!=null){
                                cell2.setCellValue(product.getProductPrice()+product.getPriceUnit());
                            }else{
                                cell2.setCellValue(product.getProductPrice()+"-");
                            }
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k ==5){//总产量
                        if(product.getTotalYield()!=null){
                            if(product.getYieldUnit()!=null){
                                cell2.setCellValue(product.getTotalYield()+product.getYieldUnit());
                            }else{
                                cell2.setCellValue(product.getTotalYield()+"-");
                            }
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 6){//成交量
                        if(product.getSoldQuantity()!=null){
                            cell2.setCellValue(product.getSoldQuantity());
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 7){//价格发布时间
                        if(product.getPriceReleaseTime()!=null){
                            cell2.setCellValue(DateUtils.formatDate(product.getPriceReleaseTime(),"yyyy/MM/dd"));
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 8){//成交时间
                        if(product.getSoldTime()!=null){
                            cell2.setCellValue(DateUtils.formatDate(product.getSoldTime(),"yyyy/MM/dd"));
                        }else{
                            cell2.setCellValue("");
                        }
                    }else if(k == 9){//产地
                        if(product.getPlaceOrigin()!=null){
                            cell2.setCellValue(product.getPlaceOrigin());
                        }else{
                            cell2.setCellValue("");
                        }
                    }
                }
            }

            FileOutputStream fileOut = null;
            try{
//                fileOut = new FileOutputStream("/product.xls");
                wb.write(out);
                return "导出成功";
            }catch(Exception e){
                e.printStackTrace();
            }
            finally{
                if(fileOut != null){
                    try {
                        fileOut.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "导出失败";
    }

    /**
     * 批量删除农场数据
     * @param ids
     * @return
     * @author lxq
     * @DATE 2018/1/4
     */
    @Override
    public int batchDelete(String[] ids) throws ServiceException {
        int result = 0;
        try {
            DFarmExample example = new DFarmExample();
            List<Long> farmIds = new ArrayList<>();
            for (int i = 0; i < ids.length; i++) {
                farmIds.add(Long.parseLong(ids[i]));
            }
            example.createCriteria().andFarmIdIn(farmIds);
            result = baseMapper.deleteByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<DFarm> getNotInRangeFarmList(String province,String city) {
        DFarmExample example = new DFarmExample();
        DFarmExample.Criteria criteria = example.createCriteria();
        criteria.andFarmProvinceNotEqualTo(province);
        criteria.andFarmCityNotEqualTo(city);
        List<DFarm> list = baseMapper.selectByExample(example);
        return list;
    }


}
