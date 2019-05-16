package com.gestion.recouvrement.bnm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Document {
    @Id
    @GeneratedValue
    private Long id;
    private String NomDocument;
    @ManyToOne
    private NotificationDeMiseEnDemeure notificationDeMiseEnDemeure;

    @ManyToOne
    private Assignation assignation;

}
