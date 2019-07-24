package com.coffeekong.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Users {
    @Id
    private Long id;
    private String email;
    private String fname;
    private String lname;

    @NotNull
    @Min(6)
    @Max(20)
    private String pwd;

}
