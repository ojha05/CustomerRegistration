package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer_registrartion_buyer")

public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="buyer_id")
    private int buyerId;

    @Column(name="buyer_name")
    private String buyerName;

    @Column(name="buyer_email")
    private String buyerEmail;

    @Column(name="buyer_password")
    private String buyerpassword;

    @Column(name="buyer_mobile")
    private long buyerMobile;

}
