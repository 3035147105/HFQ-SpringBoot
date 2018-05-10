package com.toy.server.dao.ctrade;

import com.toy.server.entity.ctrade.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by ghq on 2018/4/27.
 */
public interface UserReposity extends JpaRepository<User, Long> {
}
