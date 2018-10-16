
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
package com.bbende.notes.client.ui.home;

import com.bbende.notes.client.mvp.AbstractView;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLParagraphElement;

import static org.jboss.gwt.elemento.core.Elements.button;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.p;
import static org.jboss.gwt.elemento.core.EventType.bind;
import static org.jboss.gwt.elemento.core.EventType.click;

public class HomeViewImpl extends AbstractView<HomePresenter,HTMLDivElement> implements HomeView {

    private HTMLParagraphElement messageParagraph;
    private HTMLButtonElement newMessageButton;

    @Override
    protected HTMLDivElement createView() {
        final HTMLDivElement divElement = div()
                .add(messageParagraph = p().asElement())
                .add(newMessageButton = button().textContent("New Message").asElement())
                .asElement();

        bind(newMessageButton, click, event -> presenter.onNewMessageClicked());

        return divElement;
    }

    @Override
    public void setMessage(String message) {
        this.messageParagraph.textContent = message;
    }

}
