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

import com.bbende.notes.client.app.home.HomePresenter;
import com.bbende.notes.client.app.home.HomeView;
import com.bbende.notes.client.app.notes.place.ListNotesPlace;
import com.bbende.notes.client.mvp.AppActivityMapper;
import com.bbende.notes.client.mvp.AppPlaceHistoryMapper;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;
import org.fusesource.restygwt.client.Defaults;

/**
 * Main GWT Entry Point.
 *
 * @author bbende
 */
public class App implements EntryPoint {

    private Place defaultPlace = new ListNotesPlace();

    public void onModuleLoad() {
        useCorrectRequestBaseUrl();

        // Create ClientFactory using deferred binding so we can replace with different impls in gwt.xml
        ClientFactory clientFactory = GWT.create(ClientFactory.class);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

        // Setup the HomeView
        HomeView homeView = clientFactory.getHomeView();
        HomePresenter homePresenter = new HomePresenter(clientFactory);
        homePresenter.present(homeView);

        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(homeView.getContentPanel());

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);

        RootPanel.get().add(homeView);

        // Goes to place represented on URL or default place
        historyHandler.handleCurrentHistory();
    }

    /**
     * Reference:
     *
     * https://github.com/feedm3/spring-boot-gwt/blob/master/src/main/java/com/codecrafters/client/SpringBootGwt.java
     */
    private void useCorrectRequestBaseUrl() {
        if (isDevelopmentMode()) {
            Defaults.setServiceRoot("http://localhost:8080");
        } else {
            Defaults.setServiceRoot(GWT.getHostPageBaseURL());
        }
    }

    /**
     * Detect if the app is in development mode.
     *
     * @return true if in development mode
     */
    private static native boolean isDevelopmentMode()/*-{
        return typeof $wnd.__gwt_sdm !== 'undefined';
    }-*/;

}
