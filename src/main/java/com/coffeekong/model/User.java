package com.coffeekong.model;

import lombok.Data;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="tbl_user")
public class User {

    @Id
    @Column(name="u_email")
    private String email;

    @Column(name="u_fname")
    private String fname;

    @Column(name="u_lname")
    private String lname;

    @Column(name="u_pwd")
    private String pwd;

    @Column(name="u_point")
    private int point;

    @Column(name="sess_id")
    private String sessId;

    @Column(name="sess_limit")
    private DateTime sessLimit;

}
