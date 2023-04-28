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
@Table(name="customer_registrartion_agent")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="agent_id")
    private int agentId;

    @Column(name="agent_name")
    private String agentName;

    @Column(name="agent_email")
    private String agentEmail;

    @Column(name="agent_password")
    private String agentpassword;

    @Column(name="agent_mobile")
    private long agentMobile;
}
