package com.winchance.wechat.goodface.server.dao;

import org.springframework.dao.DataAccessException;

import com.winchance.wechat.goodface.server.dao.dataobject.ImageDo;

public interface ImageDao {
    public Long save(ImageDo imageDo) throws DataAccessException;
}
