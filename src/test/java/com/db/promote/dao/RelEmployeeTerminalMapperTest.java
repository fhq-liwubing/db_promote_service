package com.db.promote.dao;

import com.db.promote.entity.Terminal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author kun
 * @version 2018-12-29 15:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RelEmployeeTerminalMapperTest {

    @Autowired
    private RelEmployeeTerminalMapper mapper;

    @Test
    public void test() {
        List<Terminal> terminals = mapper.selectTerminalsByEmployeeNo("111");
        System.out.println(terminals);
    }


}