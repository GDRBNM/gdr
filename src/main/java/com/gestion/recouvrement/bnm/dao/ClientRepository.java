package com.gestion.recouvrement.bnm.dao;

import com.gestion.recouvrement.bnm.entities.Assignation;
import com.gestion.recouvrement.bnm.entities.Client;
import com.gestion.recouvrement.bnm.entities.Particulier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
    //URL de la liste des particulier

}
