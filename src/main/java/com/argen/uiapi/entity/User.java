package com.argen.uiapi.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ui_user")
@Data
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    public String id;
    public String userName;
    public String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role role;
}
