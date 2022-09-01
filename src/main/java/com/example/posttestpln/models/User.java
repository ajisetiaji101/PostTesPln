package com.example.posttestpln.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "username", unique = true)
    public String username;

    @Column(name = "password")
    public String password;

    @Column(name = "is_active")
    public Boolean isActive;
}
