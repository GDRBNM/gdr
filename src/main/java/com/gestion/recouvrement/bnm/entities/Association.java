package com.gestion.recouvrement.bnm.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Association")
public class Association extends Client {
private String recepisse;
    public Association(Long numClient,String recepisse, String nom, String adresse, String email, String tel,boolean actif){
    super(numClient,nom,adresse,email,tel,actif);
    this.recepisse=recepisse;
    }

public Association(){
    super();
}

}
