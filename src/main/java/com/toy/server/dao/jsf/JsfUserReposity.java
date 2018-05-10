package com.toy.server.dao.jsf;

import com.toy.server.entity.jsf.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ghq on 2018/4/29.
 */
public interface JsfUserReposity extends JpaRepository<User, Long> {
}
