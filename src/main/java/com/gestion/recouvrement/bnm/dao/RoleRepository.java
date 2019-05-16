package com.gestion.recouvrement.bnm.dao;

import com.gestion.recouvrement.bnm.entities.PartiPolitique;
import com.gestion.recouvrement.bnm.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role,Long> {
    public Role findByRoleName(String RoleName);
}
