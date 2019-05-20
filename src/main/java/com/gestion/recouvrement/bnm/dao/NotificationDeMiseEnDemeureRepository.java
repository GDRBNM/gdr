package com.gestion.recouvrement.bnm.dao;

import com.gestion.recouvrement.bnm.entities.Entreprise;
import com.gestion.recouvrement.bnm.entities.NotificationDeMiseEnDemeure;
import com.gestion.recouvrement.bnm.projection.HuissierClientProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(excerptProjection = HuissierClientProjection.class)
@CrossOrigin("*")
public interface NotificationDeMiseEnDemeureRepository extends JpaRepository<NotificationDeMiseEnDemeure,Long> {

//liste des notification de mise en demeure
    @RestResource(path = "/listeMIEND")
    @Query("select m from NotificationDeMiseEnDemeure m")
    public List<NotificationDeMiseEnDemeure> listeMIEND();

}
