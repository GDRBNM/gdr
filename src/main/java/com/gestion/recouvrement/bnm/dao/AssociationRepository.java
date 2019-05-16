package com.gestion.recouvrement.bnm.dao;

import com.gestion.recouvrement.bnm.entities.Assignation;
import com.gestion.recouvrement.bnm.entities.Association;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestResource
@CrossOrigin("*")
public interface AssociationRepository extends JpaRepository<Association,Long> {


    Page<Association> findByNomContainsOrRecepisseContainsOrAdresseContainsOrEmailContainsOrTelContains(@Param("nom") String nom, @Param("recepisse") String recepisse,@Param("adresse") String adresse,
                                                                                                        @Param("email") String email, @Param("tel") String tel, Pageable pageable);
}
