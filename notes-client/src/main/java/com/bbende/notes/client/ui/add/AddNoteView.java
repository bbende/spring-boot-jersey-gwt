
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

import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import org.jboss.gwt.elemento.core.InputType;

import static com.bbende.notes.client.ui.util.BootstrapStyles.BTN;
import static com.bbende.notes.client.ui.util.BootstrapStyles.BTN_OUTLINE_PRIMARY;
import static com.bbende.notes.client.ui.util.BootstrapStyles.FORM_CONTROL;
import static com.bbende.notes.client.ui.util.BootstrapStyles.FORM_GROUP;
import static org.jboss.gwt.elemento.core.Elements.button;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.form;
import static org.jboss.gwt.elemento.core.Elements.input;

public class AddNoteView implements AddNotePresenter.View {

    private static final String PLACEHOLDER = "Note Text";
    private static final String ADD_NOTE_BUTTON_LABEL = "Add";

    private final HTMLDivElement element;
    private final HTMLInputElement noteText;
    private final HTMLButtonElement addButton;

    public AddNoteView() {
        this.element = div()
                .add(form()
                        .add(div().css(FORM_GROUP)
                                .add(noteText = input(InputType.text)
                                    .css(FORM_CONTROL)
                                    .apply(input -> {
                                        input.placeholder = PLACEHOLDER;
                                        input.autofocus = true;
                                    })
                                    .get())
                        )
                        .add(addButton = button()
                                .css(BTN, BTN_OUTLINE_PRIMARY)
                                .textContent(ADD_NOTE_BUTTON_LABEL)
                                .get())
                )
                .get();
    }

    @Override
    public HTMLInputElement getNoteText() {
        return noteText;
    }

    @Override
    public HTMLButtonElement getAddNoteButton() {
        return addButton;
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }

}
