package com.db.promote.service.impl;

import com.db.promote.common.TagTypeEnum;
import com.db.promote.config.exception.CommonJsonException;
import com.db.promote.dao.TagMapper;
import com.db.promote.entity.Tag;
import com.db.promote.param.TagAddParam;
import com.db.promote.param.TagUpdateParam;
import com.db.promote.service.TagService;
import com.db.promote.util.constants.ErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author kun
 * @version 2019-01-06 14:59
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> getAllTag(TagTypeEnum tagType) {
        return tagMapper.selectByTagType(tagType);
    }

    @Override
    public void addTag(TagAddParam param) {
        Tag tag = new Tag();
        tag.setTagNo(UUID.randomUUID().toString().replace("-", ""));
        tag.setTagType(param.getTagType().ordinal());
        tag.setTagName(param.getTagName());
        tag.setTagScore(param.getTagScore());
        tag.setParTagNo("0");
        tag.setMeta(0);
        tag.setState(1);
        tag.setRemark(param.getRemark());
        tagMapper.insertSelective(tag);
    }

    @Override
    public void updateTag(TagUpdateParam param) {
        Tag tag = new Tag();
        tag.setTagNo(param.getTagNo());
        tag.setTagName(param.getTagName());
        tag.setTagScore(param.getTagScore());
        tag.setState(param.getState());
        tag.setRemark(param.getRemark());
        int i = tagMapper.updateByTagNoSelective(tag);
        if (i == 0) {
            throw new CommonJsonException(ErrorEnum.E_4000, "该标签不存在");
        }
    }

}
