package beans;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.AfterBegin;
import javax.ejb.AfterCompletion;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.TransactionSynchronizationRegistry;
import lt.vu.mif.trobeliunuoma.TrobeliuNuomaBean;
import lt.vu.mif.trobeliunuoma.entities.Trobele;

@Named
@Stateful
public class PirmasBean {
    @Resource
    private TransactionSynchronizationRegistry tx;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private AntrasBean antrasBean;
    @Inject
    private TrobeliuNuomaBean tnb; 
    
    @PostConstruct
    private void gimiau() {
        System.out.println(this + " gimiau.");
    }
    
    @PreDestroy
    private void tuojMirsiu() {
        System.out.println(this + " tuoj mirsiu.");
    }
    
    //---------------------------------

    public String sayKuku() {
        System.out.println(this + " Vykdau dalykinį funkcionalumą, rašau/skaitau DB...");
        Trobele trobele = new Trobele();
        trobele.setKambariuSkaicius(1);
        trobele.setPavadinimas("Ledynai" + tnb.getNumber());
        trobele.setRezervuotas(Boolean.TRUE);
        em.persist(trobele);
        return "Kuku " + new Date() + " " + toString() + " | " + antrasBean.sayKuku();
    }
    
    //---------------------------------

    @AfterBegin
    private void afterBeginTransaction() {
        System.out.println(this + " Transakcija: " + tx.getTransactionKey());
    }

    @AfterCompletion
    private void afterTransactionCompletion(boolean commited) {
        System.out.println(this + " Transakcija pasibaigė; commited: " + commited);
    }
}
