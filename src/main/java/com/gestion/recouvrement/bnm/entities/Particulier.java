package com.gestion.recouvrement.bnm.entities;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@DiscriminatorValue("Particulier")
@ApiModel(description = "Liste des attributs d'un particulier. ")
public class Particulier extends Client {
    @Size(min = 3,message = "le prenom doit avoir au minimun 3 charactere")
    @ApiModelProperty(notes ="le prenom doit avoir au minimun 3 charactere" )
    private String prenom;
    public Particulier(Long numClient,String nom,String prenom,String adresse,String email,String tel,boolean actif){

    super(numClient,nom,adresse,email,tel,actif);
    this.prenom=prenom;

    }

public Particulier(){
    super();
}



}
