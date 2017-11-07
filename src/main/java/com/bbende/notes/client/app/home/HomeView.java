package com.bbende.notes.client.app.home;

import com.bbende.notes.client.mvp.View;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Overall view for the application.
 *
 * @author bbende
 */
public interface HomeView extends View {

    void initialize(String currentUser);

    SimplePanel getContentPanel();

    HasClickHandlers getSideNavNotesLink();

    HasClickHandlers getSideNavAddNotesLink();

    HasClickHandlers getLogoutLink();

}
