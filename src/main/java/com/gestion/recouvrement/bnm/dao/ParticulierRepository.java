package com.gestion.recouvrement.bnm.dao;

import com.gestion.recouvrement.bnm.entities.Particulier;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")

@Api(description = "Gestion d'un particulier. ")
public interface ParticulierRepository extends JpaRepository<Particulier,Long> {

    //URL de la liste des particulier
    @RestResource(path = "/ListeParticuliers")
    public List<Particulier> findByActifIsTrue();
    // URL POUR CHANGER LE STATUS D'UN PARTICULIER ACTIF OU INACTIF
    //@RestResource(path = "/ActiverDesactiver{id}")
// pour la recherche d'un particulier

     Page<Particulier> findByNomContainsOrPrenomContainsOrEmailContainsOrTelContains(@Param("nom") String nom, @Param("prenom") String prenom,
                                                                                           @Param("email") String email, @Param("tel") String tel, Pageable pageable);



}