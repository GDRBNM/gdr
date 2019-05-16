package com.gestion.recouvrement.bnm.dao;

import com.gestion.recouvrement.bnm.entities.NotificationDeMiseEnDemeure;
import com.gestion.recouvrement.bnm.entities.Ordonance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrdonanceRepository extends JpaRepository<Ordonance,Long> {

}
