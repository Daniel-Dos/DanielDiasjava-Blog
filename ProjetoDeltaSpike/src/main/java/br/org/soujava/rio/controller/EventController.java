package br.org.soujava.rio.controller;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.json.stream.JsonParsingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import br.org.soujava.rio.model.Event;
import br.org.soujava.rio.model.ResponseModel;
import br.org.soujava.rio.repository.EventRepository;

@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EventController {

    @Inject
    private EventRepository eventRepository;

    @POST
    @APIResponses(
            value = {
                @APIResponse(
                        responseCode = "415", 
                        description = "Unsupported Media Type",
                        content = { @Content(mediaType = "text/plain"),
                                    @Content(mediaType = "application/xml"),
                                    @Content(mediaType = "application/pdf")}),
                @APIResponse(
                        responseCode = "404", 
                        description = "The requested resource is not available."),
                @APIResponse(
                        responseCode = "500", 
                        description = "Error: Internal Server Error"),
                @APIResponse(
                        responseCode = "200",
                        description = "Save events.",
                        content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Event.class))) })
    @Operation(
            operationId = "addEvent",
            summary = "add an Event",
            description = "This operation save events in the database")
    public Response addEvent(@RequestBody(
            description = "Create a new event.",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Event.class)), 
            required = true) Event event) {
        try {
            if (event == null) {
                return Response.status(Status.NOT_FOUND)
                        .entity(new ResponseModel(0, "The requested resource is not available.")).build();
            }
            eventRepository.save(event);
            return Response.ok().entity(new ResponseModel(1, "Event Added Successfully!")).build();
        } catch (JsonParsingException e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ResponseModel(0, e.getMessage())).build();
        }
    }

    @APIResponses(
            value = {
                @APIResponse(
                        responseCode = "500", 
                        description = "Error: Internal Server Error"),
                @APIResponse(
                        responseCode = "404", 
                        description = "The requested resource is not available."),
                @APIResponse(
                        responseCode = "415", 
                        description = "Unsupported Media Type",
                        content = { @Content(mediaType = "text/plain"),
                                    @Content(mediaType = "application/xml"),
                                    @Content(mediaType = "application/pdf")}),
                @APIResponse(
                        responseCode = "200",
                        description = "returns all events.",
                        content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Event.class))) })
    @Operation(
            operationId = "getEventsAll",
            summary = "get all of the events",
            description = "This operation retrieves events from the database")
    @GET
    public Response getEventsAll() {
        try {
            List<Event> event = eventRepository.findAll();
            if (event.isEmpty()) {
                return Response.status(Status.NOT_FOUND).entity(event).build();
            }
            return Response.ok().entity(event).build();
        } catch (JsonParsingException e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ResponseModel(0, e.getMessage())).build();
        }
    }

    @APIResponses(
            value = {
                @APIResponse(
                        responseCode = "500", 
                        description = "Error: Internal Server Error"),
                @APIResponse(
                        responseCode = "404", 
                        description = "The requested resource is not available."),
                @APIResponse(
                        responseCode = "415", 
                        description = "Unsupported Media Type",
                        content = { @Content(mediaType = "text/plain"),
                                    @Content(mediaType = "application/xml"),
                                    @Content(mediaType = "application/pdf")}),
                @APIResponse(
                        responseCode = "200",
                        description = "returns an Speaker.",
                        content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = Event.class))) })
    @Operation(
            operationId = "getSpeaker",
            summary = "gget an Speaker",
            description = "This operation find an Speaker from the database")
    @GET
    @Path("/{speaker}")
    public Response getSpeaker(@PathParam("speaker") String speaker) {
        try {
            Optional<Event> event = eventRepository.findBySpeaker(speaker);
            if (!event.isPresent()) {
                return Response.status(Status.NOT_FOUND).entity(event).build();
            }
            return Response.ok().entity(event).build();
        } catch (JsonParsingException e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ResponseModel(0, e.getMessage())).build();
        }
    }
}
