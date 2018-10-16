package com.bbende.notes.client.ui.layout;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

/**
 * Creates the overall layout of the body element and provides a div that will
 * be updated on navigation actions.
 */
public interface Layout extends IsElement<HTMLElement> {

    /**
     * @return the nav element for the layout
     */
    Nav getNavElement();

    /**
     * @return a div element to update on navigation actions
     */
    HTMLDivElement getContentElement();

}
