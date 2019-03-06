
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
package com.bbende.notes.client.service;

import com.bbende.notes.shared.Note;
import org.gwtproject.http.client.Request;
import org.gwtproject.http.client.RequestBuilder;
import org.gwtproject.http.client.RequestCallback;
import org.gwtproject.http.client.RequestException;
import org.gwtproject.http.client.Response;
import org.gwtproject.user.window.client.Cookies;

public class NoteService {

    public void getNotes(final ServiceCallback<Note[]> callback) {
        final RequestBuilder request = new RequestBuilder(RequestBuilder.GET, "/api/notes");
        try {
            request.sendRequest(null, new RequestCallback(){
                @Override
                public void onResponseReceived(final Request request, final Response response) {
                    Note[] notes = JSON.parse(response.getText());
                    callback.onSuccess(request, notes);
                }

                @Override
                public void onError(final Request request, final Throwable exception) {
                    callback.onError(exception);
                }
            });

        } catch (RequestException e) {
            callback.onError(e);
        }
    }

    public void addNote(final Note note, final ServiceCallback<Note> callback) {
        final String jsonNote = JSON.stringify(note);

        final RequestBuilder request = new RequestBuilder(RequestBuilder.POST, "/api/notes");
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Accept", "application/json");

        final String xsrfToken = Cookies.getCookie("XSRF-TOKEN");
        request.setHeader("X-XSRF-TOKEN", xsrfToken);

        try {
            request.sendRequest(jsonNote, new RequestCallback(){
                @Override
                public void onResponseReceived(final Request request, final Response response) {
                    Note note = JSON.parse(response.getText());
                    callback.onSuccess(request, note);
                }

                @Override
                public void onError(final Request request, final Throwable exception) {
                    callback.onError(exception);
                }
            });

        } catch (RequestException e) {
            callback.onError(e);
        }
    }

}
