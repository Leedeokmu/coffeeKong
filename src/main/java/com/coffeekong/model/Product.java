package com.coffeekong.model;


import lombok.Data;
import org.joda.time.DateTime;

import javax.persistence.*;

@Data
@Entity
@Table(name="tbl_review")
public class Product {

    @Id
    @Column(name="p_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="p_category")
    private String category;
    @Column(name="p_name")
    private String name;
    @Column(name="p_content")
    private String content;
    @Column(name="p_price")
    private Double price;
    @Column(name="p_mdate")
    private DateTime mdate;
    @Column(name="p_rdate")
    private DateTime rdate;
    @Column(name="p_img")
    private String img;


}

