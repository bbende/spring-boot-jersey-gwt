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

import com.bbende.notes.client.ui.add.AddNotePresenter;
import com.bbende.notes.client.ui.add.AddNotePresenterImpl;
import com.bbende.notes.client.ui.add.AddNoteView;
import com.bbende.notes.client.ui.add.AddNoteViewImpl;
import com.bbende.notes.client.ui.home.HomePresenter;
import com.bbende.notes.client.ui.home.HomePresenterImpl;
import com.bbende.notes.client.ui.home.HomeView;
import com.bbende.notes.client.ui.home.HomeViewImpl;
import com.bbende.notes.client.ui.layout.Layout;
import com.bbende.notes.client.ui.layout.Nav;
import elemental2.dom.HTMLElement;
import org.gwtproject.event.logical.shared.ValueChangeEvent;
import org.gwtproject.event.logical.shared.ValueChangeHandler;
import org.gwtproject.user.history.client.History;
import org.jboss.gwt.elemento.core.Elements;

public class ApplicationController implements ValueChangeHandler<String> {

    public static final String TOKEN_LIST = "list";
    public static final String TOKEN_ADD = "add";

    private Nav navElement;
    private HTMLElement container;

    public void bind(Layout layout) {
        this.navElement = layout.getNavElement();
        this.container = layout.getContentElement();
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
        navElement.onHistoryChange("");

        final HomeView view = new HomeViewImpl();
        final String message = "Welcome to Notes!";

        final HomePresenter presenter = new HomePresenterImpl(view, message);
        presenter.go(container);
    }

    private void doList() {
        navElement.onHistoryChange("list");
        Elements.removeChildrenFrom(container);
        container.appendChild(Elements.p().textContent("LIST").get());
    }

    private void doAdd() {
        navElement.onHistoryChange("add");

        final AddNoteView view = new AddNoteViewImpl();

        final AddNotePresenter presenter = new AddNotePresenterImpl(view);
        presenter.go(container);
    }

}
