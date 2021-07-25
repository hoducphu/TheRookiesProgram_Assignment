package com.project.ecommercewebsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int roleId;

    @Column(name = "role", unique = true, nullable = false)
    private String role;

    public Role() {
        super();
    }

    public Role(int id, String role) {
        super();
        this.roleId = id;
        this.role = role;
    }
}
