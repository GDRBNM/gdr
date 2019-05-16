package com.gestion.recouvrement.bnm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity @Data @NoArgsConstructor

@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",discriminatorType=DiscriminatorType.STRING)
public abstract class  Client {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private Long numClient;
    private String nom;
    private String adresse;
    private String email;
    private String tel;
    private boolean actif=true;

    @Column(name = "TYPE",insertable = false,updatable = false)
    private String type;
    @OneToMany(mappedBy = "client")
    private Collection<NotificationDeMiseEnDemeure> notificationDeMiseEnDemeures =new ArrayList<>();

    public Client(Long numClient,String nom, String adresse, String email, String tel,boolean actif) {
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.actif=actif;
        this.numClient=numClient;
    }



}
