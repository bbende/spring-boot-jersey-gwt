package com.bbende.notes.client;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * @author bbende
 */
public interface AppResources extends ClientBundle {

    interface Normalize extends CssResource {
    }

    interface Style extends CssResource {
    }

    @Source("css/normalize.gss")
    Normalize normalize();

    @Source("css/style.gss")
    Style style();
}