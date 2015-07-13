package com.winchance.wechat.goodface.server.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.winchance.wechat.goodface.server.dao.ConfigDao;

public class ConfigDaoImpl extends SqlMapClientDaoSupport implements ConfigDao {
    @Override
    public String get(String key)
            throws DataAccessException {
        return (String) getSqlMapClientTemplate().queryForObject("SELECT-GOODFACE-CONFIG-VALUE-BY-KEY", key);
    }
}
