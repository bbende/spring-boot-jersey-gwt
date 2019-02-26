package com.bbende.notes.client.ui.list;

import com.bbende.notes.shared.Note;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLParagraphElement;
import org.jboss.gwt.elemento.core.Elements;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.p;

public class ListNotesView implements ListNotesPresenter.View {

    private HTMLDivElement element;

    public ListNotesView() {
        this.element = div().get();
    }

    @Override
    public void setNotes(final Note[] notes) {
        Elements.removeChildrenFrom(element);
        if (notes == null || notes.length == 0) {
            final HTMLParagraphElement paragraph = p()
                    .textContent("No notes available, add one to get started!")
                    .get();
            element.appendChild(paragraph);
        } else {
            for (Note note : notes) {
                final HTMLParagraphElement paragraph = p().textContent(note.text).get();
                element.appendChild(paragraph);
            }
        }
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }
}
