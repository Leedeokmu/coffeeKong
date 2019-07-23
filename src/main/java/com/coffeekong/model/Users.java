package com.coffeekong.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class Users {
    @Id
    private Long id;
    private String email;
    private String fname;
    private String lname;
    private String pwd;

    public Users(String email, String fname, String lname, String pwd) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.pwd = pwd;
    }
}
