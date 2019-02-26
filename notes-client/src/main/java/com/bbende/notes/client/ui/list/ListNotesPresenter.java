
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
package com.bbende.notes.client.ui.list;

import com.bbende.notes.client.mvp.Presenter;
import com.bbende.notes.client.service.NoteService;
import com.bbende.notes.client.service.ServiceCallback;
import com.bbende.notes.shared.Note;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.gwtproject.http.client.Request;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

public class ListNotesPresenter implements Presenter {

    /**
     * Contract between this presenter and view impls.
     */
    public interface View extends IsElement<HTMLDivElement> {
        void setNotes(Note[] notes);
    }

    private final View view;
    private final NoteService service;

    public ListNotesPresenter(final View view, final NoteService service) {
        this.view = view;
        this.service = service;
        loadNotes();
    }

    private void loadNotes() {
        service.getNotes(new ServiceCallback<Note[]>() {
            @Override
            public void onSuccess(Request request, Note[] notes) {
                view.setNotes(notes);
            }

            @Override
            public void onError(Request request, Throwable exception) {
                DomGlobal.alert("Error: " + exception.getMessage());
            }
        });
    }

    @Override
    public void go(final HTMLElement container) {
        Elements.removeChildrenFrom(container);
        container.appendChild(view.element());
    }
}
