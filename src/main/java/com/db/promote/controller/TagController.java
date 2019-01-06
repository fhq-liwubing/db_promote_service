package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.common.TagTypeEnum;
import com.db.promote.entity.Tag;
import com.db.promote.param.TagAddParam;
import com.db.promote.param.TagUpdateParam;
import com.db.promote.service.TagService;
import com.db.promote.util.CommonUtil;
import com.db.promote.util.DateUtil;
import com.db.promote.vo.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kun
 * @version 2019-01-06 14:59
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private TagService tagService;

    @RequestMapping("/list")
    public JSONObject list(Integer tagType) {
        List<Tag> allTag = tagService.getAllTag(TagTypeEnum.values()[tagType]);
        return CommonUtil.successList(allTag.stream().map(this::buildVO).collect(Collectors.toList()));
    }

    @PostMapping("/add")
    public JSONObject add(@Validated @RequestBody TagAddParam param) {
        tagService.addTag(param);
        return CommonUtil.successJson();
    }

    @PostMapping("/update")
    public JSONObject update(@Validated @RequestBody TagUpdateParam param) {
        tagService.updateTag(param);
        return CommonUtil.successJson();
    }

    private TagVO buildVO(Tag tag) {
        TagVO vo = new TagVO();
        vo.setTagNo(tag.getTagNo());
        vo.setTagName(vo.getTagName());
        vo.setTagScore(tag.getTagScore());
        vo.setRemark(tag.getRemark());
        vo.setCreateTime(DateUtil.format(tag.getCreateTime()));
        vo.setUpdateTime(DateUtil.format(tag.getUpdateTime()));
        return vo;
    }

}
