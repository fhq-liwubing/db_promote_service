package com.db.promote.dao;

import com.db.promote.entity.Terminal;
import com.db.promote.param.AssignTerminalParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author kun
 * @version 2019-01-06 16:37
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TerminalMapperTest {

    @Autowired
    private TerminalMapper terminalMapper;

    @Test
    public void test() {
        AssignTerminalParam param = new AssignTerminalParam();
        List<Terminal> terminals = terminalMapper.selectByExampleForAssign(param);
        System.out.println(terminals);
    }


}