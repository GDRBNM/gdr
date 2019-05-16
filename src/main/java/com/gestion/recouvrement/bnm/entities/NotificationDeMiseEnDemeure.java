package com.gestion.recouvrement.bnm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class NotificationDeMiseEnDemeure {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateNotification;
    private double soldeNotification;
    private int statusNotification;
    private String decisionNotification;
    private double soldeInitiale;

    @Temporal(TemporalType.DATE)
    private Date dateOctroie;
private Long numeroCompte;
    @ManyToOne
    private Client client;

@ManyToOne
    private Huissier huissier;


@OneToMany(mappedBy = "notificationDeMiseEnDemeure")
private Collection<Document> documents=new ArrayList<>();

    @OneToMany(mappedBy = "notificationDeMiseEnDemeure")
    private Collection<Assignation> assignations=new ArrayList<>();


    public NotificationDeMiseEnDemeure(Date dateNotification, double soldeNotification, int statusNotification, String decisionNotification, double soldeInitiale, Date dateOctroie,Long numeroCompte) {
        this.dateNotification = dateNotification;
        this.soldeNotification = soldeNotification;
        this.statusNotification = statusNotification;
        this.decisionNotification = decisionNotification;
        this.soldeInitiale = soldeInitiale;
        this.dateOctroie = dateOctroie;
        this.numeroCompte=numeroCompte;
    }
}
