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
package com.bbende.notes.client.app.home;

import com.bbende.notes.client.ClientFactory;
import com.bbende.notes.client.app.notes.place.AddNotePlace;
import com.bbende.notes.client.app.notes.place.ListNotesPlace;
import com.bbende.notes.client.user.UserService;
import com.google.gwt.user.client.Window;
import gwt.material.design.client.ui.MaterialLink;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.TextCallback;

/**
 * @author bbende
 */
public class HomePresenter {

    private ClientFactory clientFactory;

    public HomePresenter(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public void present(HomeView homeView, String currentUser) {
        homeView.initialize(currentUser);

        // setup click handlers for menu links

        MaterialLink notesLink = homeView.getSideNavNotesLink();

        notesLink.addClickHandler(event -> {
            clientFactory.getPlaceController().goTo(new ListNotesPlace());
        });

        MaterialLink addNoteLink = homeView.getSideNavAddNotesLink();

        addNoteLink.addClickHandler(event -> {
            clientFactory.getPlaceController().goTo(new AddNotePlace());
        });

        // setup click handler for logout link

        MaterialLink logoutLink = homeView.getLogoutLink();

        logoutLink.addClickHandler(event -> {
            final UserService userService = clientFactory.getUserService();
            userService.logout(new TextCallback() {

                @Override
                public void onFailure(Method method, Throwable exception) {
                    Window.alert("Unable to log out: " + exception.getMessage() + " " + method.getResponse().getStatusCode());
                }

                @Override
                public void onSuccess(Method method, String response) {
                    Window.Location.replace("/login?logout");
                }
            });
        });
    }
}
