
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

import com.bbende.notes.client.mvp.Presenter;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.EventType.bind;
import static org.jboss.gwt.elemento.core.EventType.click;

public class HomePresenter implements Presenter {

    public interface View extends IsElement<HTMLDivElement> {
        void setMessage(String message);
        HTMLButtonElement getNewMessageButton();
    }

    private View view;

    public HomePresenter(final View view, final String message) {
        this.view = view;
        this.view.setMessage(message);
        bind(this.view.getNewMessageButton(), click, event -> onNewMessageClicked());
    }

    private void onNewMessageClicked() {
        view.setMessage("The time is " + System.currentTimeMillis());
    }

    @Override
    public void go(HTMLElement container) {
        Elements.removeChildrenFrom(container);
        container.appendChild(view.element());
    }
}
