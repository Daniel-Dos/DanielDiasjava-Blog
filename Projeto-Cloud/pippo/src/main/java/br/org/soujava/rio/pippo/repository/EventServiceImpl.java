package br.org.soujava.rio.pippo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.org.soujava.rio.pippo.model.Event;

public class EventServiceImpl implements EventService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EventServiceImpl() {
        this.emf = Persistence.createEntityManagerFactory("event-demo");
    }

    @Override
    public List<Event> getAll() {
        this.em = emf.createEntityManager();
        this.em.getTransaction().begin();
        return this.em.createQuery("from Event", Event.class).getResultList();
    }

    @Override
    public void save(Event event) {
        this.em = emf.createEntityManager();
        this.em.getTransaction().begin();
        this.em.persist(event);
        this.em.getTransaction().commit();
        this.em.close();
    }
}