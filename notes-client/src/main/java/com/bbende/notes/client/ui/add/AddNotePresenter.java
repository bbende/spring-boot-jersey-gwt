
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
package com.bbende.notes.client.ui.add;

import com.bbende.notes.client.ApplicationController;
import com.bbende.notes.client.mvp.Presenter;
import com.bbende.notes.client.service.NoteService;
import com.bbende.notes.client.service.ServiceCallback;
import com.bbende.notes.shared.Note;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import org.gwtproject.http.client.Request;
import org.gwtproject.user.history.client.History;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.EventType.bind;
import static org.jboss.gwt.elemento.core.EventType.click;

public class AddNotePresenter implements Presenter {

    public interface View extends IsElement<HTMLDivElement> {
        HTMLInputElement getNoteText();
        HTMLButtonElement getAddNoteButton();
    }

    private final View view;
    private final NoteService service;

    public AddNotePresenter(final View view, final NoteService service) {
        this.view = view;
        this.service = service;

        final HTMLButtonElement addNoteButton = this.view.getAddNoteButton();
        bind(addNoteButton, click, event -> onAddClicked());
    }

    public void onAddClicked() {
        final Note note = new Note();
        note.text = view.getNoteText().value;

        service.addNote(note, new ServiceCallback<Note>() {
            @Override
            public void onSuccess(final Request request, final Note dto) {
                History.newItem(ApplicationController.TOKEN_LIST);
                History.fireCurrentHistoryState();
            }

            @Override
            public void onError(final Throwable exception) {
                DomGlobal.alert("Error: " + exception.getMessage());
            }
        });
    }

    @Override
    public void go(HTMLElement container) {
        Elements.removeChildrenFrom(container);
        container.appendChild(view.element());
    }
}
