package com.bbende.notes.client;

import elemental2.dom.HTMLElement;
import org.gwtproject.event.logical.shared.ValueChangeEvent;
import org.gwtproject.event.logical.shared.ValueChangeHandler;
import org.gwtproject.user.history.client.History;
import org.jboss.gwt.elemento.core.Elements;

public class AppController implements ValueChangeHandler<String> {

    private HTMLElement container;

    public AppController(HTMLElement container) {
        this.container = container;
        this.bind();
    }

    private void bind() {
        History.addValueChangeHandler(this);
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
        String token = event.getValue();

        if ((token != null) && (!token.equals(""))) {
            if (token.startsWith("LIST")) {
                doList();
            } else if (token.contains("ADD")) {
                doAdd();
            }
        } else {
            doWelcome();
        }
    }

    private void doWelcome() {
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
