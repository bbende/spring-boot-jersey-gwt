package com.bbende.notes.client.app.notes;

import com.bbende.notes.shared.Note;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Client service for Notes.
 *
 * @author bbende
 */
@Path("/api/notes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface NotesService extends RestService {

    @GET
    void getAll(MethodCallback<List<Note>> notes);

    @GET
    @Path("/{id}")
    void get(@PathParam("id") String id, MethodCallback<Note> callback);

    @POST
    void create(Note note, MethodCallback<Note> callback);

    @PUT
    @Path("/{id}")
    void update(Note note, MethodCallback<Note> callback);

    @DELETE
    @Path("/{id}")
    void delete(@PathParam("id") String id, MethodCallback<Note> callback);

}
