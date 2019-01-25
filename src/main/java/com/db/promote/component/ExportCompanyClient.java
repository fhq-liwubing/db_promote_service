package com.db.promote.component;

import com.db.promote.entity.CompanyOrigin;
import com.db.promote.service.CompanyOriginService;
import com.db.promote.util.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lib on 2019/1/24.
 * 导出公司临时表
 */
@Slf4j
@Component
public class ExportCompanyClient {


    @Autowired
    private CompanyOriginService companyOriginService;

    /**
     * 导出所有公司资料
     */
    public void exportCompany() {
        List<String> provinceList = CityClient.provinceListAll();
        //循环导出
        String path = "d://export_company/";//导出路径
        Integer count = 0;
        provinceList.forEach(province -> {
            List<CompanyOrigin> companyOrigins= companyOriginService.findCompanyByProvince
                    (province);

            log.info("省份：{}，条数：{}",province,companyOrigins.size());
            export(companyOrigins,path,province);
        });
    }


    private void export(List<CompanyOrigin> companyOrigins,String path,String province) {
        String columns[] = {
                "公司名称", "联系人姓名", "手机号", "省份", "城市", "来源", "地址", "公司简介"
        };
        String keys[] = {
                "compayName", "accName", "phone", "provinces", "city", "sourceType", "addr", "business"
        };
        List<Map<String, Object>> list = createExcelRecord(companyOrigins,province);

        File file = new File(path);
        //文件夹不存在创建文件夹
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileNames = path + province+ ".xls";
        log.info("开始导出路径：{}",fileNames);
        try {
            ExcelUtil.createWorkBook(list, keys, columns).write(new FileOutputStream(fileNames));
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("导出完毕：{}",fileNames);
    }


    private List<Map<String, Object>> createExcelRecord(List<CompanyOrigin> pojoList,String province) {
        log.info("进入拼装生成省份参数：{}",province);
        List<Map<String, Object>> payMap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", province);
        payMap.add(map);
        CompanyOrigin pojo = null;
        for (int j = 0; j < pojoList.size(); j++) {
            pojo = pojoList.get(j);
            Map<String, Object> payMapValue = new HashMap<String, Object>();
            payMapValue.put("compayName", pojo.getCompayName());
            payMapValue.put("accName", pojo.getAccName());
            payMapValue.put("phone", pojo.getPhone());
            payMapValue.put("provinces", pojo.getProvinces());
            payMapValue.put("city", pojo.getCity());
            payMapValue.put("sourceType", pojo.getSourceType().getMsg());
            payMapValue.put("addr", pojo.getAddr());
            payMapValue.put("business", pojo.getBusiness());
            payMap.add(payMapValue);
        }
        log.info("结束拼装生成省份：{}",province);
        return payMap;
    }

}
