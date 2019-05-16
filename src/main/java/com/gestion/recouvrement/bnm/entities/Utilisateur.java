package com.gestion.recouvrement.bnm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String username;
    private String password;
    private String adresse;
    private String email;
    private String tel;

    private Boolean active;
    @ManyToMany(fetch= FetchType.EAGER)
    private Collection<Role> roles=new ArrayList<>();

    public Utilisateur(String username, String password, String adresse, String email, String tel, Boolean active) {
        this.username = username;
        this.password = password;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.active = active;
    }
}
