package com.gestion.recouvrement.bnm.dao;

import com.gestion.recouvrement.bnm.entities.Role;
import com.gestion.recouvrement.bnm.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    public Utilisateur findByUsername(String username);
}
