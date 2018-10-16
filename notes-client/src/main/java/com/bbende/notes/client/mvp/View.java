package com.bbende.notes.client.mvp;

import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

public interface View<P extends Presenter, E extends HTMLElement> extends IsElement<E> {

    void setPresenter(P presenter);

}
