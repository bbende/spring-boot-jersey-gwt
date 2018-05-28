package com.bbende.notes.client.layout;

import elemental2.dom.HTMLBodyElement;
import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.IsElement;

/**
 * Creates the overall layout of the body element and provides a div that will
 * be updated on navigation actions.
 */
public interface Layout extends IsElement<HTMLBodyElement> {

    /**
     * @return the nav element for the layout
     */
    Nav getNavElement();

    /**
     * @return a div element to update on navigation actions
     */
    HTMLDivElement getContentElement();

}
