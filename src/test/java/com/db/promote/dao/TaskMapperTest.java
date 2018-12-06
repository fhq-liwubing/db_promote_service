package com.db.promote.dao;

import com.db.promote.entity.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author kun
 * @version 2018-12-02 23:08
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void testInsert() {
        Task task = new Task();
        task.setCompanyNo("asd");
        task.setCompleteTime(null);
        task.setProgress(1);
        task.setTaskPackageNo("sadasd");
        task.setStatus("1");
        task.setCreateTime(new Date());
        task.setUpdateTime(new Date());
        taskMapper.insert(task);
    }


}