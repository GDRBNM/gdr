package com.gestion.recouvrement.bnm.service;

import com.gestion.recouvrement.bnm.dao.DocumentRepository;
import com.gestion.recouvrement.bnm.dao.NotificationDeMiseEnDemeureRepository;
import com.gestion.recouvrement.bnm.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

@CrossOrigin("*")
@RestController
public class NotificationDeMiseEnDemeureRestController {

    @Autowired
    NotificationDeMiseEnDemeureRepository notificationDeMiseEnDemeureRepository;

    @Autowired
    DocumentRepository documentRepository;
    @PostMapping(value = "/SaveMED")
    public NotificationDeMiseEnDemeure notificationDeMiseEnDemeure
            (@RequestBody NotificationDeMiseEnDemeure MED,
             @RequestParam("idClient") Long idClient,
             @RequestParam("idHuissier") Long idHuissier,
<<<<<<< HEAD
             @RequestParam("type") String type,
            @RequestParam("file") MultipartFile file) throws Exception{
        Huissier huissier = new Huissier();
        Document document=new Document();
=======
             @RequestParam("type") String type
            ) throws Exception{
        Huissier huissier = new Huissier();
>>>>>>> samba
        if (type.equals("Particulier")) {
            Client a = new Particulier();
            a.setId(idClient);
            huissier.setId(idHuissier);
            MED.setClient(a);
            MED.setDateNotification(new Date());
            MED.setHuissier(huissier);
            NotificationDeMiseEnDemeure notificationDeMiseEnDemeure=notificationDeMiseEnDemeureRepository.save(MED);
<<<<<<< HEAD
=======
            /*
>>>>>>> samba
            //enregistrement du document
            Files.write(Paths.get(System.getProperty("user.home")+"/IdeaProjects/GDR-pdf/pdf/"+file.getOriginalFilename()),file.getBytes());
            //enregistrement de l'id de la notification de la mise en demeure
            document.setNotificationDeMiseEnDemeure(notificationDeMiseEnDemeure);
            document.setNomDocument(file.getOriginalFilename().toString());
            documentRepository.save(document);
<<<<<<< HEAD
            System.out.println(documentRepository.save(document));
=======
            */
>>>>>>> samba
            return notificationDeMiseEnDemeureRepository.save(MED);
        }
return null;
    }

<<<<<<< HEAD
=======
    @PostMapping(value = "/uploadPdf/{id}")
    public Document uploadPhoto(MultipartFile file,@PathVariable Long id)throws Exception{
        Document document=new Document();
        NotificationDeMiseEnDemeure notificationDeMiseEnDemeure=new NotificationDeMiseEnDemeure();
        //enregistrement du document
        Files.write(Paths.get(System.getProperty("user.home")+"/IdeaProjects/GDR-pdf/pdf/"+file.getOriginalFilename()),file.getBytes());
        //enregistrement de l'id de la notification de la mise en demeure
        notificationDeMiseEnDemeure.setId(id);
        document.setNotificationDeMiseEnDemeure(notificationDeMiseEnDemeure);
        document.setNomDocument(file.getOriginalFilename().toString());
        return documentRepository.save(document);

    }
>>>>>>> samba

/*
    @Autowired
    NotificationDeMiseEnDemeureRepository notificationDeMiseEnDemeureRepository;
    @PostMapping(value = "/SaveMED/{idClient}/{idHuissier}")
    public NotificationDeMiseEnDemeure notificationDeMiseEnDemeure(@RequestBody NotificationDeMiseEnDemeure MED,
                                                                   @PathVariable("idClient") Long idClient,@PathVariable("idHuissier") Long idHuissier){
        Client a=new Particulier();
        a.setId(idClient);
        Huissier huissier=new Huissier();
        huissier.setId(idHuissier);
        MED.setClient(a);
        MED.setHuissier(huissier);
        return notificationDeMiseEnDemeureRepository.save(MED);
    }
*/

}
