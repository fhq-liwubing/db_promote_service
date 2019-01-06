package com.db.promote.controller;

import com.alibaba.fastjson.JSONObject;
import com.db.promote.entity.ContactBook;
import com.db.promote.param.BookQueryParam;
import com.db.promote.param.BookRefreshParam;
import com.db.promote.service.ContactBookService;
import com.db.promote.util.CommonUtil;
import com.db.promote.util.DateUtil;
import com.db.promote.vo.ContactBookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

/**
 * @author kun
 * @version 2019-01-06 16:51
 */
@RestController
@RequestMapping("/book")
public class ContactBookController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ContactBookService bookService;

    @GetMapping("/list")
    public JSONObject list() {
        return CommonUtil.successPage(bookService.pageSearch(
                CommonUtil.requestToPageReq(request, BookQueryParam.class)),
                this::buildVO
        );
    }

    @GetMapping("/my/{phoneNo}")
    public JSONObject getMyBook(@PathVariable String phoneNo) {
        return CommonUtil.successList(bookService.queryByPhoneNo(phoneNo).stream()
                .filter(b -> b.getState() == 1)
                .map(this::buildVO)
                .collect(Collectors.toList())
        );
    }

    @PostMapping("/my/refresh")
    public JSONObject refresh(@Validated @RequestBody BookRefreshParam param) {
        bookService.refresh(param);
        return CommonUtil.successJson();
    }

    public ContactBookVO buildVO(ContactBook book) {
        ContactBookVO vo = new ContactBookVO();
        vo.setPhoneNo(book.getPhoneNo());
        vo.setContactPhone(book.getContactPhone());
        vo.setContactName(book.getContactName());
        vo.setContactCompanyName(book.getContactCompanyName());
        vo.setContactCompanyNo(book.getContactCompanyNo());
        vo.setContactAddress(book.getContactAddress());
        vo.setContactEmail(book.getContactEmail());
        vo.setContactWechat(book.getContactWechat());
        vo.setRemark(book.getRemark());
        vo.setState(book.getState());
        vo.setCreateTime(DateUtil.format(book.getCreateTime()));
        vo.setUpdateTime(DateUtil.format(book.getUpdateTime()));
        return vo;
    }

}
