package com.db.promote.dao;

import com.db.promote.entity.Terminal;
import com.db.promote.vo.TerminalVO;
import org.apache.ibatis.annotations.Mapper;import java.util.List;

/**
 * Created by Mybatis Generator 2018/12/06
 */
@Mapper
public interface TerminalMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Terminal record);

    int insertSelective(Terminal record);

    Terminal selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Terminal record);

    int updateByPrimaryKey(Terminal record);

    List<Terminal> selectByExample(Terminal example);

    List<TerminalVO> selectVOByExample(Terminal example);
}