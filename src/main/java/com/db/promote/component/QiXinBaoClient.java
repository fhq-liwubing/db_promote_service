package com.db.promote.component;

import com.db.promote.entity.Commpay;
import com.db.promote.service.CommpayService;
import com.db.promote.utils.GsonUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by lib on 2018/11/21.
 */
@Service
public class QiXinBaoClient {
      @Autowired
      private CommpayService commpayService;

    private static final Logger log = LoggerFactory.getLogger(QiXinBaoClient.class);

    /**
     * 读取Excel返回文件
     * @param path
     * @param commpayList
     * @return
     * @throws IOException
     */
    public List<Commpay> createExcel(String path, List<Commpay> commpayList) throws IOException, InvalidFormatException {
        log.info("启信宝Excel导入");
        File excel = new File(path);
        Workbook wb = null;
        if (excel.isFile() && excel.exists()) {
            String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
            //根据文件后缀（xls/xlsx）进行判断
            if ( "xls".equals(split[1])){
                FileInputStream fis = new FileInputStream(excel);   //文件流对象
                wb = new HSSFWorkbook(fis);
            }else if ("xlsx".equals(split[1])){
                wb = new XSSFWorkbook(excel);
            }else {
                log.info("文件类型错误,{}",path);
                return null;
            }
        }

        // Read the Sheet
        //解析Excel
        for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++) {
            Sheet sheet = wb.getSheetAt(numSheet);
            if (sheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row hssfRow = sheet.getRow(rowNum);
                if (hssfRow != null) {
                    Commpay commpay = new Commpay();
                    Cell business = hssfRow.getCell(7);
                    Cell compayName = hssfRow.getCell(0);
                    Cell accName = hssfRow.getCell(4);
                    Cell addr = hssfRow.getCell(9);
                    Cell phone = hssfRow.getCell(8);
                    Cell provinces = hssfRow.getCell(2);//省份
                    Cell city = hssfRow.getCell(3);//城市
                    if(GanjiClient.clearData(business.toString())&&
                            GanjiClient.clearBisiness(business.toString())){
                        commpay.setBusiness(business.toString());
                    }else {
                        continue;
                    }
                    if(GanjiClient.clearData(compayName.toString())){
                        commpay.setCompayName(compayName.toString());
                    }else {
                        continue;
                    }
                    if(GanjiClient.clearData(accName.toString())){
                        commpay.setAccName(accName.toString());
                    }else {
                        continue;
                    }
                    if(GanjiClient.clearData(addr.toString())){
                        commpay.setAddr(addr.toString());
                    }else {
                        continue;
                    }
                    if(GanjiClient.clearPhone(phone.toString())){
                        commpay.setPhone(phone.toString());
                    }else {
                        continue;
                    }
                    commpay.setType("启信宝");
                    commpay.setProvinces(provinces.toString());
                    commpay.setCity(city.toString());
                    //commpayList.add(commpay);
                    //这里保存数据库
                    commpayService.insert(commpay);
                   log.info("导出数据：{}",GsonUtil.buildGson().toJson(commpay));
                }
            }
        }
        return commpayList;

    }
}
