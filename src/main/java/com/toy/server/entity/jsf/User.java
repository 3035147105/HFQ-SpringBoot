package com.toy.server.entity.jsf;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Created by ghq on 2018/4/29.
 */
@Entity
@Table(name = "jsf_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private long id;

    @Column(name = "f_name", length = 20)
    @NotEmpty
    private String name;

    @Column(name = "f_password", length = 30)
    @NotEmpty
    private String password;

    @Column(name = "f_age")
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
