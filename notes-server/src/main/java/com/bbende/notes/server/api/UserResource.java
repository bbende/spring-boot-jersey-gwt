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

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author bbende
 */
@Component
@Path("/current-user")
public class UserResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCurrentUser() {
        final User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        final com.bbende.notes.shared.User currentUser = new com.bbende.notes.shared.User();
        currentUser.setUsername(user.getUsername());

        return Response.ok().entity(currentUser).build();
    }
}
