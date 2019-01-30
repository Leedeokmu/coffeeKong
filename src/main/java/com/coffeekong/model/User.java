package com.coffeekong.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name="tbl_user", uniqueConstraints = @UniqueConstraint(columnNames = "u_email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name="u_email")
    private String email;

    @Column(name="u_fname")
    private String fname;

    @Column(name="u_lname")
    private String lname;

    @Column(name="u_pwd")
    private String pwd;

}
