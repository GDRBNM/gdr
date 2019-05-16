package com.gestion.recouvrement.bnm.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("PartiPolitique")
public class PartiPolitique extends Client {
    @Column(unique=true)
    private String idPartie;
    public PartiPolitique(Long numClient,String idPartie, String nom, String adresse, String email, String tel,boolean actif){

    super(numClient,nom,adresse,email,tel,actif);
    this.idPartie=idPartie;
    }

public PartiPolitique(){
    super();
}

}
