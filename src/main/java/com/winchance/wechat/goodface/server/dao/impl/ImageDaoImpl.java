package com.winchance.wechat.goodface.server.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.winchance.wechat.goodface.server.dao.ImageDao;
import com.winchance.wechat.goodface.server.dao.dataobject.ImageDo;

public class ImageDaoImpl extends SqlMapClientDaoSupport implements ImageDao {
    @Override
    public Long save(ImageDo imageDo)
            throws DataAccessException {
        return (Long) getSqlMapClientTemplate().insert("SAVE-GOODFACE-IMAGE", imageDo);
    }
}
