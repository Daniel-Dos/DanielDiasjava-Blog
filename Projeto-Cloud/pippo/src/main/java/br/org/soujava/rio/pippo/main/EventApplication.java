package br.org.soujava.rio.pippo.main;

import br.org.soujava.rio.pippo.model.Event;
import br.org.soujava.rio.pippo.model.ResponseModel;
import br.org.soujava.rio.pippo.repository.EventService;
import br.org.soujava.rio.pippo.repository.EventServiceImpl;
import ro.pippo.core.Application;

public class EventApplication extends Application {

    @Override
    protected void onInit() {

        POST("/events", routeContext -> {
            EventService eventRepository = new EventServiceImpl();
            Event event = routeContext.createEntityFromBody(Event.class);
            eventRepository.save(event);
            routeContext.json().send(new ResponseModel(routeContext.getResponse().ok().getStatus(), "Evento salvo com Sucesso !"));
        });

        GET("/events", routeContext -> {
            EventService eventRepository = new EventServiceImpl();
            routeContext.json().getResponse().send(eventRepository.getAll());
        });
    }
}