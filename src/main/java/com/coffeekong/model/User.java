package com.coffeekong.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Table
public class User implements Serializable {

    @Id
    private Long id;
    @NotNull
    private String email;
    private String fname;
    private String lname;
    @NotNull
    private String pwd;

}
