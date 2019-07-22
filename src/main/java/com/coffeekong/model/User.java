package com.coffeekong.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class User {

    @Id
    private Long id;
    private String email;
    private String fname;
    private String lname;
    private String pwd;



}
