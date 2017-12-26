package com.example.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(generator = "UUID")
    private  String id;

    private String role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
