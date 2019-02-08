package br.org.soujava.rio.pippo.repository;

import java.util.List;

import br.org.soujava.rio.pippo.model.Event;

public interface EventService {

    List<Event> getAll();
    void save(Event event);
}