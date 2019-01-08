package br.org.soujava.rio.jooby.main;

import java.util.Optional;

import javax.inject.Inject;

import org.jooby.Jooby;
import org.jooby.banner.Banner;
import org.jooby.hbm.Hbm;
import org.jooby.jdbc.Jdbc;
import org.jooby.json.Jackson;

import br.org.soujava.rio.jooby.model.Event;
import br.org.soujava.rio.jooby.model.ResponseModel;
import br.org.soujava.rio.jooby.repository.EventServiceImpl;

public class AppMain extends Jooby {

      @Inject
      EventServiceImpl service;
      
      public static Optional<String> port = Optional.ofNullable(System.getenv("PORT"));

    {

        use(new Banner("SouJava").font("slant"));
        use(new Jackson());
        use(new Jdbc());
        use(new Hbm().classes(Event.class));
        
        port(Integer.parseInt(port.orElse("8080")));

        onStart( () ->             
            service.save(new Event("MicroFrameworks","A Solução moderna para seus MicroServices.","Daniel Dias"))
        );

        path("app/events", () -> {

            get(()-> service.getAll());

            post((req, res) -> {
                var event = req .body(Event.class); 
                service.save(event);
             
                res.send(new ResponseModel(1, "Evento adicionado ! "));
            });
        });
    }

    public static void main (String[] args) {
        run(AppMain::new, args);
    }
}