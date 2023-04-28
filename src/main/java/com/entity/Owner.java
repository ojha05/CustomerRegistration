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
@Table(name="customer_registrartion_owner")

public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="owner_id")
    private int ownerId;

    @Column(name="owner_name")
    private String ownerName;

    @Column(name="owner_email")
    private String ownerEmail;

    @Column(name="owner_password")
    private String ownerpassword;

    @Column(name="owner_mobile")
    private long ownerMobile;





}
