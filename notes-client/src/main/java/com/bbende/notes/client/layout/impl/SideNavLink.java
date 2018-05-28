
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
package com.bbende.notes.client.layout.impl;

import com.bbende.notes.client.layout.NavLink;
import elemental2.dom.HTMLAnchorElement;

import static com.bbende.notes.client.util.CustomStyles.NAVBAR_SIDE_LINK;
import static com.bbende.notes.client.util.CustomStyles.NAVBAR_SIDE_LINK_ACTIVE;
import static org.jboss.gwt.elemento.core.Elements.a;

public class SideNavLink implements NavLink {

    private String urlToken;
    private HTMLAnchorElement anchorElement;

    public SideNavLink(String label, String urlToken) {
        this.anchorElement = a(urlToken)
                .css(NAVBAR_SIDE_LINK)
                .textContent(label)
                .asElement();

        this.urlToken = urlToken.startsWith("#") ? urlToken.replaceFirst("#", "") : urlToken;
    }

    @Override
    public HTMLAnchorElement asElement() {
        return anchorElement;
    }

    @Override
    public String getUrlToken() {
        return urlToken;
    }

    @Override
    public void activate() {
        if (!anchorElement.classList.contains(NAVBAR_SIDE_LINK_ACTIVE)) {
            anchorElement.classList.add(NAVBAR_SIDE_LINK_ACTIVE);
        }
    }

    @Override
    public void deactivate() {
        if (anchorElement.classList.contains(NAVBAR_SIDE_LINK_ACTIVE)) {
            anchorElement.classList.remove(NAVBAR_SIDE_LINK_ACTIVE);
        }
    }

}
