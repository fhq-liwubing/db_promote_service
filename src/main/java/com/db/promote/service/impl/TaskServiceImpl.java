package com.db.promote.service.impl;

import com.db.promote.common.PageRequest;
import com.db.promote.config.exception.CommonJsonException;
import com.db.promote.dao.CompanyMapper;
import com.db.promote.dao.TaskCallMapper;
import com.db.promote.dao.TaskPackageMapper;
import com.db.promote.entity.Company;
import com.db.promote.entity.TaskCall;
import com.db.promote.entity.TaskPackage;
import com.db.promote.param.PackageAddParam;
import com.db.promote.param.PackageQueryParam;
import com.db.promote.service.TaskService;
import com.db.promote.util.constants.ErrorEnum;
import com.db.promote.util.constants.ProcessStatusEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author kun
 * @version 2019-01-06 10:41
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private TaskPackageMapper packageMapper;
    @Autowired
    private TaskCallMapper callMapper;

    @Override
    public PageInfo<TaskPackage> packagePageSearch(PageRequest<PackageQueryParam> pageRequest) {
        return PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageRow())
                .doSelectPageInfo(() -> packageMapper.selectByExample(pageRequest.getExample()));
    }

    @Override
    public void packageAdd(PackageAddParam param) {
        List<Company> companies = companyMapper.selectByCompanyNoIn(param.getCompanyNo());
        Map<String, Company> companyMap = companies.stream()
                .collect(Collectors.toMap(Company::getCompanyNo, Function.identity()));
        if (!companyMap.keySet().containsAll(Arrays.stream(param.getCompanyNo()).collect(Collectors.toSet()))) {
            throw new CommonJsonException(ErrorEnum.E_4000, "公司信息不存在");
        }
        companyMap = null;

        String packageNo = UUID.randomUUID().toString().replace("-", "");
        switch (param.getTaskType()) {
            case CALL:
                List<TaskCall> taskList = companies.stream()
                        .map(this::buildCall).peek(c -> c.setPackageNo(packageNo)).collect(Collectors.toList());
                callMapper.insertList(taskList);
                break;
            case MSG:
                // TODO
                break;
            default:
        }

        TaskPackage taskPackage = new TaskPackage();
        taskPackage.setPackageNo(packageNo);
        taskPackage.setPackageName(param.getPackName());
        taskPackage.setTaskType(param.getTaskType().ordinal());
        taskPackage.setProcessStatus(ProcessStatusEnum.INIT.ordinal());
        taskPackage.setState(1);
        taskPackage.setRemark(param.getRemark());
        packageMapper.insertSelective(taskPackage);
    }

    private TaskCall buildCall(Company company) {
        TaskCall taskCall = new TaskCall();
        taskCall.setTaskNo(UUID.randomUUID().toString().replace("-", ""));
        taskCall.setCompanyNo(company.getCompanyNo());
        taskCall.setProcessStatus(ProcessStatusEnum.INIT.ordinal());
        taskCall.setContactPhoneList(company.getPhone());
        taskCall.setState(1);
        // no packageNo
        return taskCall;
    }


}
