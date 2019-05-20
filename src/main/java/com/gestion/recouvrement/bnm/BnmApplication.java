package com.gestion.recouvrement.bnm;

import com.gestion.recouvrement.bnm.dao.*;
import com.gestion.recouvrement.bnm.entities.*;
import com.gestion.recouvrement.bnm.service.AccountService;
import com.gestion.recouvrement.bnm.thread.MEDdateThreadCounter;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
public class BnmApplication extends RepositoryRestConfigurerAdapter implements CommandLineRunner {

    @Autowired
    PartiePolitiqueRepository partiePolitiqueRepository;
    @Autowired
    ParticulierRepository particulierRepository;
    @Autowired
    AssociationRepository associationRepository;
    @Autowired
    EntrepriseRepository entrepriseRepository;
    @Autowired
    NotificationDeMiseEnDemeureRepository notificationDeMiseEnDemeureRepository;
@Autowired
    HuissierRepository huissierRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;
    int  z=0;
    @Autowired
    MEDdateThreadCounter meDdateThreadCounter;
    public static void main(String[] args) {
        SpringApplication.run(BnmApplication.class, args);
    }

   /* @Override
    public void configureValidatingRepositoryEventListener(
            ValidatingRepositoryEventListener v) {
        v.addValidator("beforeCreate", new ParticulierValidator());
    }
*/
    @Override
    public void run(String... args) throws Exception {
repositoryRestConfiguration.exposeIdsFor(Particulier.class);
        repositoryRestConfiguration.exposeIdsFor(Association.class);
        repositoryRestConfiguration.exposeIdsFor(Entreprise.class);
        repositoryRestConfiguration.exposeIdsFor(PartiPolitique.class,Huissier.class);
        repositoryRestConfiguration.exposeIdsFor(NotificationDeMiseEnDemeure.class);

        /*
         * Ajout d'un Particulier
         *
         */
        Random rnd=new Random();
        for (int i=0 ;i <=5; i++){
            Particulier particulier=new Particulier(10000+(long)i,RandomString.make(4).toLowerCase(),RandomString.make(4).toLowerCase(),RandomString.make(4).toLowerCase(),RandomString.make(4).toLowerCase(),"4345865"+i,rnd.nextBoolean());
            particulierRepository.save(particulier);
        }


        /*
         * Fin Ajout d'un Particulier
         *
         * */



        /*
         * Ajout d'une Association
         *
         */

        for (int i=0 ;i <=5; i++){

            Association association=new Association(20000+(long)i,RandomString.make(4).toLowerCase(),RandomString.make(4).toLowerCase(),RandomString.make(4).toLowerCase(),RandomString.make(4).toLowerCase(),"4345865"+i,rnd.nextBoolean());
            associationRepository.save(association);
        }


        /*
         * Fin Ajout d'une Association
         *
         * */





        /*
         * Ajout d'une Entrprise
         *
         */

        String RaisonSociale[]=new String[2];
        RaisonSociale[0]="SARL";
        RaisonSociale[1]="SA";

        for (int i=0 ;i <=5; i++){

            Entreprise entreprise=new Entreprise(30000+(long)i,RaisonSociale[rnd.nextInt(2)+0],RandomString.make(4).toLowerCase(),RandomString.make(4).toLowerCase(),RandomString.make(4).toLowerCase(),"4345865"+i,RandomString.make(5).toLowerCase(),rnd.nextBoolean());
            entrepriseRepository.save(entreprise);
        }


        /*
         * Fin Ajout d'une Entreprise
         *
         * */





        /*
         * Ajout d'un Partie politique
         *
         */



        for (int i=0 ;i <=5; i++){

            PartiPolitique partiPolitique=new PartiPolitique(40000+(long)i,RandomString.make(4).toLowerCase(),RandomString.make(4).toLowerCase(),RandomString.make(4).toLowerCase(),RandomString.make(4).toLowerCase(),"4345865"+i,rnd.nextBoolean());
            partiePolitiqueRepository.save(partiPolitique);
        }


        /*
         * Fin Ajout d'un Partie politique
         *
         */





        /*
         * Ajout d'une liste D'huissier
         *
         *
         */


          for (int i=0;i<=6;i++){
              Huissier huissier=new Huissier("huissier"+i,"huissier"+i, RandomString.make(8).toLowerCase(), RandomString.make(8).toLowerCase(), "4345865"+i,true);

              huissierRepository.save(huissier);
          }


        /*
         * Fin Ajout d'une liste D'huissier
         *
         * */




        /*
         * Ajout d'une notification de mise en demeure pour chaque particulier
         *
         * */
        String decsionNotifiction[] =new String[3];
        decsionNotifiction[0]="en cour";
        decsionNotifiction[1]="en Appel";
        decsionNotifiction[2]="en Cassation";

        Random rnd1=new Random();

        List<Particulier> zte =  particulierRepository.findAll();
        zte.forEach(particulier -> {

            NotificationDeMiseEnDemeure notificationDeMiseEnDemeure=
                    new NotificationDeMiseEnDemeure
                            (new Date(), 52258.3, rnd.nextBoolean(), "",5878.0,new Date(),Long.parseLong(String.valueOf(rnd.nextInt())) );

            //id du client Concerner par la mise en demeure
            notificationDeMiseEnDemeure.setClient(particulier);
            //Recuperation de l'identifiant du particulier pour un compte donner
//            Compte compte= compteRepository.findById(particulier.getId()).get();

            //           notificationDeMiseEnDemeure.setCompte(compte);

            //id de l'huissier qui va prendre en charge le dossier

            List<Huissier> huissiers=huissierRepository.findAll();

            notificationDeMiseEnDemeure.setHuissier(huissiers.get(z));
            z++;

// fin id de l'huissier qui va prendre en charge le dossier
            notificationDeMiseEnDemeureRepository.save(notificationDeMiseEnDemeure);

        });

        /*
         * Fin Ajout d'une notification de mise en demeure pour chaque particulier
         *
         * */



        // creation user
        accountService.saveUser(new Utilisateur("ADMIN","123","","","",true));
        accountService.saveUser(new Utilisateur("RSR","123","","","",true));
        accountService.saveUser(new Utilisateur("AGENT","123","","","",true));
        accountService.saveRole(new Role(null, "ADMIN"));
        accountService.saveRole(new Role(null, "RESPONSABLE"));
        accountService.saveRole(new Role(null, "AGENT"));
        accountService.addRoleToUser("ADMIN", "ADMIN");
        accountService.addRoleToUser("RSR", "AGENT");
        accountService.addRoleToUser("RSR", "RESPONSABLE");
        accountService.addRoleToUser("AGENT", "AGENT");
       // accountService.addRoleToUser("admin", "RESPONSABLE_R");



        /*
        *  Debut  Thread notification de mise ne demeure
        *
        */


        meDdateThreadCounter.start();


        /*
        *
        * fin Thread notification de mise ne demeure
        *
        * */
    }

    @Bean
    public BCryptPasswordEncoder getBrcy() {
        return new BCryptPasswordEncoder();
    }
/*
    @Bean
    public ParticulierValidator beforeCreateWebsiteUserValidator() {
        return new ParticulierValidator();
    }
*/
}
