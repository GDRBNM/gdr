package com.gestion.recouvrement.bnm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignation {
    @Id
    @GeneratedValue
    private Long id;
    private Date dateAssignation;
    private int statusAssignation;
private String commentaire;
    @ManyToOne
    private NotificationDeMiseEnDemeure notificationDeMiseEnDemeure;
    @OneToMany(mappedBy = "assignation")
    private Collection<Document>documents=new ArrayList<>();

    @ManyToOne
    private Cour cour;

    public Assignation(Date dateAssignation, int statusAssignation, String commentaire) {
        dateAssignation = dateAssignation;
        statusAssignation = statusAssignation;
        this.commentaire = commentaire;
    }
}
