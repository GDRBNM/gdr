package com.gestion.recouvrement.bnm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ordonance {
    @Id
    @GeneratedValue
    private Long id;
    private double montant;
    private String commentaire;

    @OneToOne
    private Assignation assignation;

    public Ordonance(double montant, String commentaire) {
        this.montant = montant;
        this.commentaire = commentaire;
    }
}
