package com.gestion.recouvrement.bnm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cour {
    @Id
    @GeneratedValue
    private Long id;
    private String NomCour;
    @OneToMany(mappedBy = "cour")
   private Collection<Assignation>assignations=new ArrayList<>();

}
