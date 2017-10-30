package com.bbende.notes.client.app.home;

import com.bbende.notes.client.mvp.View;
import com.google.gwt.user.client.ui.SimplePanel;
import gwt.material.design.client.ui.MaterialLink;

/**
 * Overall view for the application.
 *
 * @author bbende
 */
public interface HomeView extends View {

    void initialize(String currentUser);

    SimplePanel getContentPanel();

    MaterialLink getSideNavNotesLink();

    MaterialLink getSideNavAddNotesLink();

    MaterialLink getLogoutLink();

}
