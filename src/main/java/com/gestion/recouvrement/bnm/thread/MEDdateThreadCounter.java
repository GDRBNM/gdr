package com.gestion.recouvrement.bnm.thread;

import com.gestion.recouvrement.bnm.dao.NotificationDeMiseEnDemeureRepository;
import com.gestion.recouvrement.bnm.entities.NotificationDeMiseEnDemeure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public class MEDdateThreadCounter extends Thread {
@Autowired
    NotificationDeMiseEnDemeureRepository notificationDeMiseEnDemeureRepository;
    @Override
    public void run() {
        while (true){
            List<NotificationDeMiseEnDemeure> notificationDeMiseEnDemeures=notificationDeMiseEnDemeureRepository.findAll();
if(notificationDeMiseEnDemeures!=null){

    notificationDeMiseEnDemeures.forEach(t->{
 if ( ((new Date()).getTime()-t.getDateNotification().getTime()) /(1000*60) >=1){
     t.setStatusNotification(false);
     notificationDeMiseEnDemeureRepository.save(t);
 }
    });
}

        }


    }


}
