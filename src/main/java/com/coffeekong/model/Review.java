package com.coffeekong.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="tbl_review")
public class Review {

    @Id
    @Column(name="r_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="p_id")
    private Integer productId;

    @Column(name="u_email")
    private String email;

    @Column(name="u_name")
    private String name;

    @Column(name="r_grade")
    private String grade;

    @Column(name="r_content")
    private String content;

    @Column(name="r_date")
    private Date date;
}
