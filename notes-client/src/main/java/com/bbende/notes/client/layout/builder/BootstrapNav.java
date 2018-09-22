
/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bbende.notes.client.layout.builder;

import com.bbende.notes.client.layout.Nav;
import com.bbende.notes.client.layout.NavLink;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.jboss.gwt.elemento.core.Elements.*;
import static org.jboss.gwt.elemento.core.EventType.bind;
import static org.jboss.gwt.elemento.core.EventType.click;
import static com.bbende.notes.client.util.BootstrapStyles.*;
import static com.bbende.notes.client.util.CustomStyles.*;
import static com.bbende.notes.client.util.Roles.*;

/**
 * Bootstrap implementation of the Nav element that contains a toggle-able side nav.
 */
public class BootstrapNav implements Nav {

    public static final String NAV_TAG = "nav";
    public static final String NAVBAR_BRAND_LABEL_TEXT = "Notes";
    public static final String HREF_EMPTY = "#";

    private HTMLButtonElement navbarSideToggleButton;
    private HTMLAnchorElement navbarTopLinkSignOut;

    private HTMLUListElement navbarSide;
    private NavLink navbarSideLinkHome;
    private NavLink navbarSideLinkList;
    private NavLink navbarSideLinkAdd;
    private List<NavLink> navbarSideLinks;
    private boolean navbarSideIsOpen = false;

    private HTMLElement navElement;
    private HTMLElement mainElement;

    public BootstrapNav(HTMLElement mainElement) {
        this.mainElement = mainElement;

        this.navbarSideLinkHome = new SideNavLink("Home", "#");
        this.navbarSideLinkList = new SideNavLink("List", "#list");
        this.navbarSideLinkAdd = new SideNavLink("Add", "#add");

        this.navElement = htmlElement(NAV_TAG, HTMLElement.class)
                .css(NAVBAR, NAVBAR_DARK, BG_PRIMARY, FIXED_TOP)
                .attr(ROLE_ATTR, ROLE_NAVIGATION)
                .add(div().css(NAVBAR_BRAND)
                        .add(navbarSideToggleButton = button()
                                .css(NAVBAR_TOGGLER)
                                .add(span().css(NAVBAR_TOGGLER_ICON))
                                .asElement())
                        .add(a(HREF_EMPTY)
                                .css(NAVBAR_BRAND, NAVBAR_BRAND_LABEL)
                                .textContent(NAVBAR_BRAND_LABEL_TEXT))
                )
                .add(ul().css(NAVBAR_NAV)
                        .add(li().css(NAV_ITEM)
                                .add(navbarTopLinkSignOut = a(HREF_EMPTY)
                                        .css(NAV_LINK)
                                        .textContent("Sign Out")
                                        .asElement()))
                )
                .add(navbarSide = ul()
                        .css(NAVBAR_SIDE)
                        .add(li().css(NAVBAR_SIDE_ITEM).add(navbarSideLinkHome))
                        .add(li().css(NAVBAR_SIDE_ITEM).add(navbarSideLinkList))
                        .add(li().css(NAVBAR_SIDE_ITEM).add(navbarSideLinkAdd))
                        .asElement()
                )
                .asElement();

        bind(navbarSideToggleButton, click, event -> toggleSideNav());
        bind(navbarTopLinkSignOut, click, event -> signOut());

        navbarSideLinks = new ArrayList<>();
        navbarSideLinks.add(navbarSideLinkHome);
        navbarSideLinks.add(navbarSideLinkList);
        navbarSideLinks.add(navbarSideLinkAdd);

        navbarSideLinkHome.activate();
    }

    private void toggleSideNav() {
        if (navbarSideIsOpen) {
            navbarSide.classList.remove(NAVBAR_SIDE_REVEAL);
            mainElement.classList.remove(PUSH_MAIN);
            navbarSideIsOpen = false;
        } else {
            navbarSide.classList.add(NAVBAR_SIDE_REVEAL);
            mainElement.classList.add(PUSH_MAIN);
            navbarSideIsOpen = true;
        }
    }

    private void signOut() {
        // placeholder for later
    }

    @Override
    public void onHistoryChange(String urlToken) {
        navbarSideLinks.stream().forEach(navLink -> navLink.deactivate());

        Optional<NavLink> matchingLink = navbarSideLinks.stream()
                .filter(l -> l.getUrlToken().equals(urlToken))
                .findFirst();

        if (matchingLink.isPresent()) {
            matchingLink.get().activate();
        }
    }

    @Override
    public HTMLElement asElement() {
        return navElement;
    }

}
