package com.db.promote.service;

import com.db.promote.common.PageRequest;
import com.db.promote.entity.ContactBook;
import com.db.promote.param.BookQueryParam;
import com.db.promote.param.BookRefreshParam;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author kun
 * @version 2019-01-06 16:57
 */
public interface ContactBookService {

    PageInfo<ContactBook> pageSearch(PageRequest<BookQueryParam> pageRequest);

    List<ContactBook> queryByPhoneNo(String phoneNo);

    void refresh(BookRefreshParam param);
}
