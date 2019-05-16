package com.gestion.recouvrement.bnm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Huissier {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String tel;
    private boolean active=true;
    @OneToMany(mappedBy = "huissier")
    private Collection<NotificationDeMiseEnDemeure> notificationDeMiseEnDemeures = new ArrayList<>();

    public Huissier(String nom, String prenom, String adresse, String email, String tel, boolean active) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.active=active;
    }
}