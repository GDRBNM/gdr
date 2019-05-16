package com.gestion.recouvrement.bnm.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("Entreprise")
public class Entreprise extends Client {
private String raisonSociale;
    @Column(unique=true)
    private String numero;
    public Entreprise(Long numClient,String raisonSociale,String nom, String adresse, String email, String tel,String numero,boolean actif){

    super(numClient,nom,adresse,email,tel,actif);
    this.numero=numero;
    this.raisonSociale=raisonSociale;
    }

public Entreprise(){
    super();
}

}
