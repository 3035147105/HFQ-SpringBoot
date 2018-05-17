package com.toy.server.controller;

import com.toy.server.dao.ctrade.UserReposity;
import com.toy.server.entity.ctrade.User;
import com.toy.server.service.Tut1Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ghq on 2018/4/27.
 */
@RestController
public class UserController {
    @Autowired
    private UserReposity userReposity;

    @Autowired
    private Tut1Sender tut1Sender;

    @RequestMapping(value = "/user/get/")
    public String get() {
        List<User> userList = userReposity.findAll();
        return userList.get(0).toString();
    }

    @RequestMapping(value = "/rabbit/hello/")
    public void helloWorld() {
        tut1Sender.send();
    }
}
