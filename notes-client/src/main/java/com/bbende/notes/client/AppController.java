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
package com.bbende.notes.client;

import elemental2.dom.HTMLElement;
import org.gwtproject.event.logical.shared.ValueChangeEvent;
import org.gwtproject.event.logical.shared.ValueChangeHandler;
import org.gwtproject.user.history.client.History;
import org.jboss.gwt.elemento.core.Elements;

public class AppController implements ValueChangeHandler<String> {

    public static final String TOKEN_LIST = "list";
    public static final String TOKEN_ADD = "add";

    private HTMLElement container;

    public void bind(HTMLElement container) {
        this.container = container;
        History.addValueChangeHandler(this);
        History.fireCurrentHistoryState();
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        String token = event.getValue();

        if ((token != null) && (!token.equals(""))) {
            if (token.startsWith(TOKEN_LIST)) {
                doList();
            } else if (token.contains(TOKEN_ADD)) {
                doAdd();
            }
        } else {
            doHome();
        }
    }

    private void doHome() {
        Elements.removeChildrenFrom(container);
        container.appendChild(Elements.p().textContent("WELCOME").asElement());
    }

    private void doList() {
        Elements.removeChildrenFrom(container);
        container.appendChild(Elements.p().textContent("LIST").asElement());
    }

    private void doAdd() {
        Elements.removeChildrenFrom(container);
        container.appendChild(Elements.p().textContent("ADD").asElement());
    }

}
