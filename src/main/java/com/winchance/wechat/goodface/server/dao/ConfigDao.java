package com.winchance.wechat.goodface.server.dao;

import org.springframework.dao.DataAccessException;

public interface ConfigDao {
    public String get(String key) throws DataAccessException;
}
