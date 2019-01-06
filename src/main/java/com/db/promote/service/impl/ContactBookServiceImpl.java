package com.db.promote.service.impl;

import com.db.promote.common.PageRequest;
import com.db.promote.dao.ContactBookMapper;
import com.db.promote.entity.ContactBook;
import com.db.promote.param.BookQueryParam;
import com.db.promote.param.BookRefreshParam;
import com.db.promote.service.ContactBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kun
 * @version 2019-01-06 16:57
 */
@Service
public class ContactBookServiceImpl implements ContactBookService {

    @Autowired
    private ContactBookMapper bookMapper;

    @Override
    public PageInfo<ContactBook> pageSearch(PageRequest<BookQueryParam> pageRequest) {
        return PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageRow())
                .doSelectPageInfo(() -> bookMapper.selectByExample(pageRequest.getExample()));
    }

    @Override
    public List<ContactBook> queryByPhoneNo(String phoneNo) {
        return bookMapper.selectByPhoneNo(phoneNo);
    }

    @Override
    public void refresh(BookRefreshParam param) {
        // 第一步置为无效
        bookMapper.updateBookDisable(param.getPhoneNo());
        // 第二部更新
        BookRefreshParam.BookInfo[] infoList = param.getInfoList();
        for (BookRefreshParam.BookInfo info : infoList) {
            ContactBook book = new ContactBook();
            book.setPhoneNo(param.getPhoneNo());
            book.setContactName(info.getContactName());
            book.setContactCompanyNo(info.getContactCompanyNo());
            book.setContactCompanyName(info.getContactCompanyName());
            book.setContactPhone(info.getContactPhone());
            book.setContactAddress(info.getContactAddress());
            book.setContactEmail(info.getContactEmail());
            book.setContactWechat(info.getContactWechat());
            book.setState(1);
            book.setRemark(info.getRemark());
            bookMapper.insertOrUpdate(book);
        }
    }

}
