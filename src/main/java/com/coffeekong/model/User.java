package com.coffeekong.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name="tbl_user", uniqueConstraints = @UniqueConstraint(columnNames = "u_email"))
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name="u_email")
    private String email;

    @Column(name="u_fname")
    private String fname;

    @Column(name="u_lname")
    private String lname;

    @NotNull
    @Column(name="u_pwd")
    private String pwd;

}
