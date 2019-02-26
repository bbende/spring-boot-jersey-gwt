/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bbende.notes.server.api;

import com.bbende.notes.shared.Note;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Path("/notes")
public class NoteResource {

    private final List<Note> notes = new ArrayList<Note>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public NoteResource() {
        Note note1 = new Note();
        note1.text = "This is note 1.";
        create(note1);

        Note note2 = new Note();
        note2.text = "This is note 2.";
        create(note2);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotes() {
        return Response.ok(notes).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Note note) {
        note.id = idCounter.getAndIncrement();
        synchronized (notes) {
            notes.add(note);
        }
        return Response.ok(note).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Integer id) {
        synchronized (notes) {
            Iterator<Note> iter = notes.iterator();
            while (iter.hasNext()) {
                Note note = iter.next();
                if (note.id == id.intValue()) {
                    return Response.ok(note).build();
                }
            }
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") final Integer id, Note note) {
        synchronized (notes) {
            Iterator<Note> iter = notes.iterator();
            while (iter.hasNext()) {
                Note existingNote = iter.next();
                if (note.id == id.intValue()) {
                    existingNote.text = note.text;
                    return Response.ok(note).build();
                }
            }
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") final Integer id) {
        synchronized (notes) {
            Iterator<Note> iter = notes.iterator();
            while (iter.hasNext()) {
                Note note = iter.next();
                if (note.id == id.intValue()) {
                    iter.remove();
                    return Response.ok(note).build();
                }
            }
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
