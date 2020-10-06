package com.argen.uiapi.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "ui_user")
@Data
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String userName;
    public String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role role;
}
