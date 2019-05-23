package br.org.soujava.rio.vertx.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.org.soujava.rio.vertx.models.Evento;

@Repository
public interface EventoRepository extends EntityRepository<Evento, Long> { }
