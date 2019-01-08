package br.org.soujava.rio.jooby.repository;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.org.soujava.rio.jooby.model.Event;

public class EventServiceImpl implements EventService {

    private EntityManager em;

    @Inject
    public EventServiceImpl(EntityManager em) {
        this.em =  em;
    }

    @Override
    public List<Event> getAll() {
       
        return this.em.createQuery("from Event",Event.class).getResultList();
    }

    @Override
    public void save(Event event) {
        
        var trx = em.getTransaction();
         trx.begin();
         this.em.persist(event);
         trx.commit();   
    }   
}