package com.coffeekong.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_order")
public class Order {
    @Id
    @Column(name="o_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="u_email")
    private String email;

    @Column(name="o_price")
    private Double price;

    @Column(name="o_rfname")
    private String fname;

    @Column(name="o_rlname")
    private String lname;

    @Column(name="o_phone")
    private String phone;

    @Column(name="o_postcode")
    private String postcode;

    @Column(name="o_addr")
    private String addr;

    @Column(name="o_state")
    private String state;

    @Column(name="o_date")
    private Date date;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "o_id", referencedColumnName = "o_id")
    private Collection<OrderProduct> opvo = new ArrayList<>();

}
