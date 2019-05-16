package com.gestion.recouvrement.bnm.dao;


import com.gestion.recouvrement.bnm.entities.Entreprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@RepositoryRestResource

public interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {



    Page<Entreprise> findByNomContainsOrRaisonSocialeContainsOrAdresseContainsOrEmailContainsOrTelContainsOrNumeroContains(@Param("nom") String nom, @Param("raisonSociale") String RaisonSociale, @Param("adresse") String adresse,
                                                                                                           @Param("email") String email, @Param("tel") String tel,@Param("numero") String numero,Pageable pageable);
}
