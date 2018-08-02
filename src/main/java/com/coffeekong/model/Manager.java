package com.coffeekong.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@Table(name = "tbl_manager")
public class Manager {

    @Id
    @Column(name="m_email")
    private String email;

    @Column(name="m_fname")
    private String fname;

    @Column(name="m_lname")
    private String lname;

    @Column(name="m_pwd")
    private String pwd;

    @Column(name="sess_id")
    private String sessId;

    @Column(name="sess_limit")
    private Date sessLimit;

}
