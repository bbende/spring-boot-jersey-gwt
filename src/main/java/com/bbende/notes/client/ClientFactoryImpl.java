/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bbende.notes.client;

import com.bbende.notes.client.service.NotesService;
import com.bbende.notes.client.view.HomeView;
import com.bbende.notes.client.view.HomeViewImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author bbende
 */
public class ClientFactoryImpl implements ClientFactory {

    private static final EventBus EVENT_BUS = new SimpleEventBus();
    private static final PlaceController PLACE_CONTROLLER = new PlaceController(EVENT_BUS);
    private static final NotesService NOTES_SERVICE = GWT.create(NotesService.class);
    private static final HomeView HOME_VIEW = new HomeViewImpl();

    @Override
    public EventBus getEventBus() {
        return EVENT_BUS;
    }

    @Override
    public PlaceController getPlaceController() {
        return PLACE_CONTROLLER;
    }

    @Override
    public NotesService getNotesService() {
        return NOTES_SERVICE;
    }

    @Override
    public HomeView getHomeView() {
        return HOME_VIEW;
    }

}
