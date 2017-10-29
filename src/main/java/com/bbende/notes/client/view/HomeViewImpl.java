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
package com.bbende.notes.client.view;

import com.bbende.notes.client.place.NoteAddPlace;
import com.bbende.notes.client.place.NotesListPlace;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialHeader;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialNavBrand;
import gwt.material.design.client.ui.MaterialNavSection;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialSideNav;
import gwt.material.design.client.ui.MaterialSideNavCard;

/**
 * @author bbende
 */
public class HomeViewImpl extends AbstractView implements HomeView {

    private SimplePanel contentPanel;

    private PlaceController placeController;

    public HomeViewImpl(PlaceController placeController) {
        this.placeController = placeController;

        MaterialNavBar navBar = createNavBar();
        MaterialSideNav sideNav = createSideNav();

        MaterialHeader header = new MaterialHeader();
        header.add(navBar);
        header.add(sideNav);

        SimplePanel contentPanel = new SimplePanel();
        contentPanel.add(new MaterialLabel("HOME"));
        this.contentPanel = contentPanel;

        MaterialContainer contentContainer = new MaterialContainer();
        contentContainer.setPaddingTop(20);
        contentContainer.add(contentPanel);

        MaterialPanel mainContainer = new MaterialPanel();
        mainContainer.add(header);
        mainContainer.add(contentContainer);

        initWidget(mainContainer);
    }

    private MaterialNavBar createNavBar() {
        MaterialLink loginLink = new MaterialLink("Login");
        loginLink.setHref("#login");

        MaterialLink signupLink = new MaterialLink("Sign Up");
        loginLink.setHref("#signup");

        MaterialNavSection navSection = new MaterialNavSection();
        navSection.setFloat(Style.Float.RIGHT);
        navSection.add(loginLink);
        navSection.add(signupLink);

        MaterialNavBrand navBrand = new MaterialNavBrand("Notes");
        navBrand.setPaddingLeft(20);

        MaterialNavBar navBar = new MaterialNavBar();
        navBar.setActivates("mysidenav");
        navBar.setBackgroundColor(Color.BLUE);
        navBar.add(navBrand);
        navBar.add(navSection);

        return navBar;
    }

    private MaterialSideNav createSideNav() {
        MaterialLink notesLink = new MaterialLink("Notes");
        //link1.setIconType(IconType.ACCESS_ALARM);

        notesLink.addClickHandler(event -> {
            placeController.goTo(new NotesListPlace());
        });

        MaterialLink addNoteLink = new MaterialLink("Add Note");
        //link2.setIconType(IconType.ACCESS_ALARM);

        addNoteLink.addClickHandler(event -> {
            placeController.goTo(new NoteAddPlace());
        });

        MaterialSideNav sideNav = new MaterialSideNavCard();
        sideNav.setId("mysidenav");
        sideNav.setWidth(280);

        sideNav.add(notesLink);
        sideNav.add(addNoteLink);
        return sideNav;
    }

    @Override
    public SimplePanel getContentPanel() {
        return this.contentPanel;
    }

}