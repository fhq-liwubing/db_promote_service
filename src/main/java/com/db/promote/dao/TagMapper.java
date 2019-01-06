package com.db.promote.dao;

import com.db.promote.common.TagTypeEnum;import com.db.promote.entity.Tag;
import org.apache.ibatis.annotations.Mapper;import java.util.List;

/**
 * Created by Mybatis Generator 2019/01/06
 */
@Mapper
public interface TagMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    List<Tag> selectByTagType(TagTypeEnum tagType);

    int updateByTagNoSelective(Tag record);
}