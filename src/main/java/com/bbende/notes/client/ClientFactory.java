package com.bbende.notes.client;

import com.bbende.notes.client.app.home.HomeView;
import com.bbende.notes.client.app.notes.NotesService;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author bbende
 */
public interface ClientFactory {

    EventBus getEventBus();

    PlaceController getPlaceController();

    NotesService getNotesService();

    HomeView getHomeView();

}
