
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
package com.bbende.notes.client.layout.template;

import com.bbende.notes.client.layout.NavLink;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLLIElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import static com.bbende.notes.client.util.CustomStyles.NAVBAR_SIDE_LINK_ACTIVE;

@Templated
public abstract class SideNavLink implements NavLink<HTMLLIElement>, IsElement<HTMLLIElement> {

    public static SideNavLink create(String text, String token) {
        return new Templated_SideNavLink(text,
                token.startsWith("#") ? token.replaceFirst("#", "") : token);
    }

    @DataElement
    HTMLAnchorElement anchorElement;

    @Override
    public abstract String getText();

    @Override
    public abstract String getUrlToken();

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
