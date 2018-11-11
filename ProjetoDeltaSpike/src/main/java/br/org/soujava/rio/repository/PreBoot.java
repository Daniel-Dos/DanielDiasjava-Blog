package br.org.soujava.rio.repository;

import java.util.Arrays;


import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.org.soujava.rio.model.Event;

@Singleton
@Startup
@ApplicationScoped
public class PreBoot {

    @Inject
    private EventRepository eventRepository;

    @PostConstruct
    @ApplicationScoped
    void init() {
        Arrays.asList(new Event("deltaspike", "best event of earth", "Apache"),
                      new Event("MVC", "best event of earth", "Daniel"),
                      new Event("theia", "best event of earth", "Eclipse"))
              .stream()
              .forEach(event-> {
                 this.eventRepository.save(event);
              });
    }
}