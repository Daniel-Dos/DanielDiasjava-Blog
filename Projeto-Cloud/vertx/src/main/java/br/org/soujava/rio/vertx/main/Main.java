package br.org.soujava.rio.vertx.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.jboss.logging.Logger;

import br.org.soujava.rio.vertx.models.Evento;
import br.org.soujava.rio.vertx.models.ResponseModel;
import br.org.soujava.rio.vertx.repository.EventoRepository;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class Main extends AbstractVerticle {

    private final static Logger LOG = Logger.getLogger(Main.class);
    
    public static Optional<String> portCloud = Optional.ofNullable(System.getenv("PORT"));
    
    public static void main(String[] args ) throws Exception {

       var cdiContainer = CdiContainerLoader.getCdiContainer();
       cdiContainer.boot();

        var contextControl = cdiContainer.getContextControl();
        contextControl.startContext(ApplicationScoped.class);

        var eventoRepository = BeanProvider.getContextualReference(EventoRepository.class, false);

        var vertx = Vertx.vertx();
        vertx.deployVerticle(new Main());

        var router = Router.router(vertx);
        router.route().handler(BodyHandler.create());

        router.get("/api/events").handler(routingContext -> {

            routingContext.response()
                          .putHeader("content-type", "application/json; charset=utf-8")
                          .end(Json.encodePrettily(eventoRepository.findAll()));
        });

        router.post("/api/events").handler(routingContext -> {
             var event = Json.decodeValue(routingContext.getBodyAsString(), Evento.class);

             eventoRepository.save(event);

            routingContext.response()
                          .putHeader("content-type", "application/json; charset=utf-8")
                          .end(Json.encodePrettily(new ResponseModel(routingContext.response().getStatusCode(), "Evento salvo com Sucesso !")));
        });

        vertx.createHttpServer().requestHandler(router).listen(Integer.parseInt(portCloud.orElse("8080")), res -> {
            if (res.succeeded()) {
                LOG.info("Server is now listening! ".concat("http://localhost:")
                                                    .concat(String.valueOf(res.result().actualPort())
                                                    .concat("/api/events")));
            } else {
                LOG.error("Failed to bind!");
            }
        });
    }
}