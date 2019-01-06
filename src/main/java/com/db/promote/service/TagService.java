package com.db.promote.service;

import com.db.promote.common.TagTypeEnum;
import com.db.promote.entity.Tag;
import com.db.promote.param.TagAddParam;
import com.db.promote.param.TagUpdateParam;

import java.util.List;

/**
 * @author kun
 * @version 2019-01-06 14:59
 */
public interface TagService {
    List<Tag> getAllTag(TagTypeEnum tagType);

    void addTag(TagAddParam param);

    void updateTag(TagUpdateParam param);
}
