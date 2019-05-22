package br.org.soujava.rio.vertx.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.org.soujava.rio.vertx.models.Event;

@Repository
public interface EventRepository extends EntityRepository<Event, Long> { }
