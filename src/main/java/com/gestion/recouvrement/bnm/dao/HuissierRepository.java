package com.gestion.recouvrement.bnm.dao;


import com.gestion.recouvrement.bnm.entities.Huissier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;

@RepositoryRestResource
@Secured("AGENT")
public interface HuissierRepository extends JpaRepository<Huissier,Long> {

    Page<Huissier> findByNomContainsOrPrenomContainsOrTelContainsOrEmailContains(@Param("nom") String nom, @Param("prenom") String prenom,
                                                                                 @Param("tel") String tel, @Param("email") String email, Pageable pageable);
}
