package com.db.promote.test;

import com.db.promote.component.GanjiClient;
import com.db.promote.component.TianYanChaClient;
import com.db.promote.entity.CompanyOrigin;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lib on 2018/11/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TianYanChaTest {

    private static final Logger log = LoggerFactory.getLogger(TianYanChaTest.class);

//    @Autowired
//    private CompanyDao commpayDao;

    @Autowired
    private TianYanChaClient tianYanChaClient;

    @Autowired
    private GanjiClient ganjiClient;

    @Test
    public void tianYanChaClient() throws IOException, InvalidFormatException {
        List<CompanyOrigin> commpayList = new ArrayList<>();

        String filepath = "E:\\项目\\zj\\天眼查数据\\给客户版";
        File file = new File(filepath);
        if(file.isDirectory()){
            String[] filelist = file.list();
            //获取第一层文件夹
            for (String s : filelist) {
                File readfile = new File(filepath + "\\" + s);
                log.info("目录：" + readfile.getPath());
                //判断是否为文件夹
                if(readfile.isDirectory()){
                    String [] readFile1 = readfile.list();
                    //获取第二层文件夹
                    for (String s1 : readFile1){
                        File readfile2 = new File(filepath + "\\" + s + "\\" + s1);
                        log.info("目录：" + readfile2.getPath());
                        tianYanChaClient.createExcel(readfile2.getPath(),commpayList);
                    }
                }else{
                    //如果不是文件夹，则读取文件
                    tianYanChaClient.createExcel(readfile.getPath(),commpayList);
                }

            }
        }else{
            tianYanChaClient.createExcel(filepath,commpayList);
        }
        String exportPath = "config/download/";
        String fileName = "tianyanchahenan.xls";
        ganjiClient.excelData(commpayList,exportPath,fileName);
    }


}
