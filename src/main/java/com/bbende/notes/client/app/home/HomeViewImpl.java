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

import com.bbende.notes.client.mvp.AbstractView;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.SimplePanel;
import gwt.material.design.client.base.AbstractSideNav;
import gwt.material.design.client.constants.Color;
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
    private MaterialLink sideNavNotesLink;
    private MaterialLink sideNavAddNoteLink;
    private MaterialLink logoutLink;

    @Override
    public void initialize(String currentUser) {
        MaterialNavBar navBar = createNavBar(currentUser);
        AbstractSideNav sideNav = createSideNav();

        MaterialHeader header = new MaterialHeader();
        header.add(navBar);
        header.add(sideNav);

        SimplePanel contentPanel = new SimplePanel();
        contentPanel.getElement().getStyle().setPaddingLeft(40, Style.Unit.PX);
        contentPanel.getElement().getStyle().setPaddingRight(40, Style.Unit.PX);
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

    private MaterialNavBar createNavBar(String currentUser) {
        MaterialLabel userLabel = new MaterialLabel(currentUser);

        this.logoutLink = new MaterialLink("Logout");
        logoutLink.setHref("#logout");

        MaterialNavSection navSection = new MaterialNavSection();
        navSection.setFloat(Style.Float.RIGHT);
        navSection.add(userLabel);
        navSection.add(logoutLink);

        MaterialNavBrand navBrand = new MaterialNavBrand("Notes");
        navBrand.setPaddingLeft(20);

        MaterialNavBar navBar = new MaterialNavBar();
        navBar.setActivates("mysidenav");
        navBar.setBackgroundColor(Color.BLUE);
        navBar.add(navBrand);
        navBar.add(navSection);

        return navBar;
    }

    private AbstractSideNav createSideNav() {
        this.sideNavNotesLink = new MaterialLink("Notes");
        //link1.setIconType(IconType.ACCESS_ALARM);

        this.sideNavAddNoteLink = new MaterialLink("Add Note");
        //link2.setIconType(IconType.ACCESS_ALARM);

        AbstractSideNav sideNav = new MaterialSideNavCard();
        sideNav.setId("mysidenav");
        sideNav.setWidth(280);

        sideNav.add(sideNavNotesLink);
        sideNav.add(sideNavAddNoteLink);
        return sideNav;
    }

    @Override
    public SimplePanel getContentPanel() {
        return this.contentPanel;
    }

    @Override
    public MaterialLink getSideNavNotesLink() {
        return sideNavNotesLink;
    }

    @Override
    public MaterialLink getSideNavAddNotesLink() {
        return sideNavAddNoteLink;
    }

    @Override
    public MaterialLink getLogoutLink() {
        return logoutLink;
    }

}
