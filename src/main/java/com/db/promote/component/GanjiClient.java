package com.db.promote.component;

import com.db.promote.entity.Commpay;
import com.db.promote.service.CommpayService;
import com.db.promote.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

/**
 * Created by lib on 2018/11/18.
 */
@Service
public class GanjiClient {

    @Autowired
    private CommpayService commpayService;

    private static final Logger log = LoggerFactory.getLogger(GanjiClient.class);

    public static void main(String[] args) throws IOException {
//        List<Commpay> commpayList = new ArrayList<>();
//
//        String path = "C:\\Users\\lib\\Desktop\\数据导出\\ganji郑州\\郑州\\专项审批.xls";
//        String filepath = "C:\\Users\\lib\\Desktop\\数据导出\\ganji郑州";
//        File file = new File(filepath);
//        if(file.isDirectory()){
//            String[] filelist = file.list();
//            //获取第一层文件夹
//            for (String s : filelist) {
//                File readfile = new File(filepath + "\\" + s);
//                log.info("path=" + readfile.getPath());
//                //判断是否为文件夹
//                if(readfile.isDirectory()){
//                    String [] readFile1 = readfile.list();
//                    //获取第二层文件夹
//                    for (String s1 : readFile1){
//                        File readfile2 = new File(filepath + "\\" + s + "\\" + s1);
//                        log.info("path=" + readfile2.getPath());
////                        createExcel(readfile2.getPath(),commpayList);
//                    }
//                }else{
//                    //如果不是文件夹，则读取文件
////                    createExcel(readfile.getPath(),commpayList);
//                }
//
//            }
//        }
//        String exportPath = "config/download/";
//        String fileName = "赶集郑州.xls";
//        excelData(commpayList,exportPath,fileName);

    }

    /**
     * 读取Excel返回文件
     * @param path
     * @param commpayList
     * @return
     * @throws IOException
     */
    public  List<Commpay> createExcel(String path, List<Commpay> commpayList) throws IOException {
        log.info("赶集Excel导入");
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

        // Read the Sheet
        //解析Excel
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    Commpay commpay = new Commpay();
                    HSSFCell business = hssfRow.getCell(1);
                    HSSFCell compayName = hssfRow.getCell(2);
                    HSSFCell accName = hssfRow.getCell(3);
                    HSSFCell addr = hssfRow.getCell(4);
                    HSSFCell phone = hssfRow.getCell(5);
                    if(clearData(ExcelUtil.getValue(business))&&
                            clearBisiness(ExcelUtil.getValue(business))){
                        commpay.setBusiness(ExcelUtil.getValue(business));
                    }else {
                        continue;
                    }
                    if(clearData(ExcelUtil.getValue(compayName))){
                        commpay.setCompayName(ExcelUtil.getValue(compayName));
                    }else {
                        continue;
                    }
                    if(clearData(ExcelUtil.getValue(accName))){
                        commpay.setAccName(ExcelUtil.getValue(accName));
                    }else {
                        continue;
                    }
                    if(clearData(ExcelUtil.getValue(addr))){
                        commpay.setAddr(ExcelUtil.getValue(addr));
                    }else {
                        continue;
                    }
                    if(clearPhone(ExcelUtil.getValue(phone))){
                        commpay.setPhone(ExcelUtil.getValue(phone));
                    }else {
                        continue;
                    }
                    commpay.setType("赶集");
                   // commpayList.add(commpay);
                    //这里保存数据库
                    commpayService.insert(commpay);
                }
            }
        }
        try {
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

      return commpayList;

    }

    /**
     * 验证条件，去除关键字
     * @param test
     */
    public static Boolean clearData(String test){
        Boolean flag = true;

        //去除关键字
        if( test.indexOf("投资")!=-1 || test.indexOf("白银")!=-1 ||test.indexOf("股票")!=-1
                || test.indexOf("全国")!=-1 || test.indexOf("慧算账")!=-1 || test.indexOf("金融")!=-1
                || test.indexOf("机票")!=-1 || test.indexOf("金蝶")!=-1 || test.indexOf("用友")!=-1
                || test.indexOf("悟空")!=-1 || test.indexOf("慧算账") !=-1 || test.indexOf("顶呱呱")!=-1
                || test.indexOf("噼里啪")!=-1){
            log.info("不符合");
            flag = false;
        }
        return flag;
    }

    /**
     * 公司简介需要包含
     * @param bisiness
     * @return
     */
    public static Boolean clearBisiness(String bisiness){
        Boolean flag = false;
        if(bisiness.indexOf("公司注册") != -1 || bisiness.indexOf(" 注册公司")!=-1
                || bisiness.indexOf("工商注册")!=-1 || bisiness.indexOf("代理记账")!=-1){

            flag = true;
        }else{
            log.info("公司简介不符合");
        }
        return flag;
    }

    /**
     * 手机号验证
     * @param phone
     * @return
     */
    public static Boolean clearPhone(String phone){
        Boolean flag = true;
        if(phone.length()!=11 || phone.indexOf("-")!=-1 ){
            flag = false;
            log.info("不符合");
        }else if(phone.length() == 11){
            String start = phone.substring(0,3);
            if(start.indexOf("178")!=-1 || start.indexOf("176")!=-1 || start.indexOf("170")!=-1){
                flag =false;
            }
        }

        return flag;
    }


    /**
     * 导出数据
     * @param pojoList
     * @return
     */
    private static List<Map<String, Object>> createExcelRecord(List<Commpay> pojoList) {


        List<Map<String, Object>> payMap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "数据导出");
        payMap.add(map);
        Commpay pojo = null;
        for (int j = 0; j < pojoList.size(); j++) {
            pojo = pojoList.get(j);
            Map<String, Object> payMapValue = new HashMap<String, Object>();
            payMapValue.put("compayName", pojo.getCompayName());
            payMapValue.put("phone", pojo.getPhone());
            payMapValue.put("addr", pojo.getAddr());
            payMapValue.put("business", pojo.getBusiness());
            payMapValue.put("accName", pojo.getAccName());
            payMap.add(payMapValue);
        }


        return payMap;
    }

    public static void excelData(List<Commpay> commpayList,String exportPath,String fileName)
            throws IOException {

        //手机号去重
        for (int i = 0; i < commpayList.size()-1; i++) {
            for (int j = commpayList.size()-1; j > i; j--) {
                if (commpayList.get(j).getPhone().equals(commpayList.get(i).getPhone())) {
                    log.info("去掉重复的手机号：" + commpayList.get(i).getPhone());
                    commpayList.remove(j);
                }
            }
        }

        //导入Excel
        log.info("共导出：" + commpayList.size());
        List<Map<String, Object>> list = createExcelRecord(commpayList);
        String columns[] = {
                "公司名称", "联系人", "手机号", "地址", "公司简介"
        };
        String keys[] = {
                "compayName", "accName", "phone", "addr", "business"
        };
        Date d = new Date();
        String fileNames = d.getTime() + ".xls";
        File file = new File(exportPath);
        //文件夹不存在创建文件夹
        if (!file.exists()) {
            file.mkdirs();
        }
        fileName = exportPath + fileName;
        ExcelUtil.createWorkBook(list, keys, columns).write(new FileOutputStream(fileName));
    }






}
