package com.gestion.recouvrement.bnm.dao;

import com.gestion.recouvrement.bnm.entities.Assignation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.validation.Valid;

@RepositoryRestResource
public interface AssignatioRepository extends JpaRepository<@Valid Assignation,Long> {

}
