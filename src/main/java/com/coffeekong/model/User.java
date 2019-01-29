package com.coffeekong.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name="tbl_user")
public class User {

    @Id
    @Column(name="u_email")
    @NotNull
    private String email;

    @Column(name="u_fname")
    private String fname;

    @Column(name="u_lname")
    private String lname;

    @Column(name="u_pwd")
    private String pwd;

}
