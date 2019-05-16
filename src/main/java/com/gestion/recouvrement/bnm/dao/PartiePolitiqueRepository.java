package com.gestion.recouvrement.bnm.dao;

import com.gestion.recouvrement.bnm.entities.PartiPolitique;
import com.gestion.recouvrement.bnm.entities.Particulier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")

@RepositoryRestResource

public interface PartiePolitiqueRepository extends JpaRepository<PartiPolitique,Long> {

    Page<PartiPolitique>findByNomContainsOrIdPartieContainsOrAdresseContainsOrEmailContainsOrTelContains(@Param("nom") String nom, @Param("idPartie") String idPartie, @Param("adresse") String adresse,
                                                                                                 @Param("email") String email, @Param("tel") String tel,Pageable pageable);
}
