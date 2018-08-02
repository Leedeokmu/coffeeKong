package com.coffeekong.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_order_prod")
public class OrderProduct {

    @Id
    @Column(name="op_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="o_id")
    private int orderId;

    @Column(name="p_id")
    private int productId;

    @OneToOne
    @JoinColumn(name="p_id", referencedColumnName = "p_id")
    private Product product;

    @Column(name="op_qty")
    private int qty;

    @Column(name="op_sz")
    private String sz;

    @Column(name="op_type")
    private String type;

    @Column(name="op_price")
    private double price;

}

