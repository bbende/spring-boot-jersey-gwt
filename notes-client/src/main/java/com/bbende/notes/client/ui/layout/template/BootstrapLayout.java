
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
package com.bbende.notes.client.ui.layout.template;

import com.bbende.notes.client.ui.layout.Layout;
import com.bbende.notes.client.ui.layout.Nav;
import com.bbende.notes.client.ui.layout.NavLink;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.bbende.notes.client.ui.util.CustomStyles.NAVBAR_SIDE_REVEAL;
import static com.bbende.notes.client.ui.util.CustomStyles.PUSH_MAIN;
import static org.jboss.gwt.elemento.core.EventType.bind;
import static org.jboss.gwt.elemento.core.EventType.click;

@Templated
public abstract class BootstrapLayout implements Layout, Nav {

    public static BootstrapLayout create() {
        return new Templated_BootstrapLayout();
    }

    @DataElement HTMLElement main;
    @DataElement HTMLDivElement content;
    @DataElement HTMLButtonElement navToggle;
    @DataElement HTMLUListElement navSide;
    @DataElement HTMLUListElement navTop;

    private NavLink navSideLinkHome;
    private NavLink navSideLinkList;
    private NavLink navSideLinkAdd;
    private List<NavLink> navSideLinks;
    private boolean navSideIsOpen = false;

    private TopNavLink navTopLinkSignOut;

    @PostConstruct
    public void initialize() {
        // Setup side nav...
        navSideLinkHome = SideNavLink.create("Home", "#");
        navSideLinkList = SideNavLink.create("List", "#list");
        navSideLinkAdd = SideNavLink.create("Add", "#add");

        navSideLinks = Arrays.asList(
                navSideLinkHome,
                navSideLinkList,
                navSideLinkAdd);

        navSide.appendChild(navSideLinkHome.element());
        navSide.appendChild(navSideLinkList.element());
        navSide.appendChild(navSideLinkAdd.element());

        // Setup top nav links...
        navTopLinkSignOut = TopNavLink.create("Sign Out", "#");
        navTop.appendChild(navTopLinkSignOut.element());

        // Bind event handlers...
        bind(navToggle, click, event -> toggleSideNav());
        bind(navTopLinkSignOut.getAnchorElement(), click, event -> signOut());

        // Activate the home link...
        navSideLinkHome.activate();
    }

    @Override
    public Nav getNavElement() {
        return this;
    }

    @Override
    public HTMLDivElement getContentElement() {
        return content;
    }

    private void toggleSideNav() {
        if (navSideIsOpen) {
            navSide.classList.remove(NAVBAR_SIDE_REVEAL);
            main.classList.remove(PUSH_MAIN);
            navSideIsOpen = false;
        } else {
            navSide.classList.add(NAVBAR_SIDE_REVEAL);
            main.classList.add(PUSH_MAIN);
            navSideIsOpen = true;
        }
    }

    private void signOut() {
        // placeholder for later
    }

    @Override
    public void onHistoryChange(String urlToken) {
        navSideLinks.forEach(NavLink::deactivate);

        Optional<NavLink> matchingLink = navSideLinks.stream()
                .filter(l -> l.getUrlToken().equals(urlToken))
                .findFirst();

        matchingLink.ifPresent(NavLink::activate);
    }

}
