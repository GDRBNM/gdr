package com.gestion.recouvrement.bnm.projection;

import com.gestion.recouvrement.bnm.entities.Client;
import com.gestion.recouvrement.bnm.entities.Document;
import com.gestion.recouvrement.bnm.entities.Huissier;

import java.util.Collection;
import java.util.Date;

public interface HuissierClientProjection {
    Long getId();
    Date  getDateNotification();
    Double  getSoldeNotification();
    Boolean  getStatusNotification();
    String  getDecisionNotification();
    Double  getSoldeInitiale();
    Date getDateOctroie();
    String getNumeroCompte();
    Huissier getHuissier();
    Client getClient();
    Collection<Document> getDocuments();

}
