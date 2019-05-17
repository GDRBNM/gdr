package com.gestion.recouvrement.bnm.dao;

import com.gestion.recouvrement.bnm.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface DocumentRepository extends JpaRepository<Document,Long> {

}
