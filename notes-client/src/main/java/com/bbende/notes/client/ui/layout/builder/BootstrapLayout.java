
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
package com.bbende.notes.client.ui.layout.builder;

import com.bbende.notes.client.ui.layout.Layout;
import com.bbende.notes.client.ui.layout.Nav;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.Elements;

import static com.bbende.notes.client.ui.util.Roles.ROLE_ATTR;
import static com.bbende.notes.client.ui.util.Roles.ROLE_MAIN;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.htmlElement;

/**
 * Dashboard layout from bootstrap-material examples.
 */
public class BootstrapLayout implements Layout {

    public static final String MAIN_TAG = "main";

    private Nav navElement;
    private HTMLElement mainElement;
    private HTMLDivElement contentElement;
    private HTMLDivElement containerElement;

    public BootstrapLayout() {
        mainElement = htmlElement(MAIN_TAG, HTMLElement.class)
                .attr(ROLE_ATTR, ROLE_MAIN)
                .add(div().add(contentElement = div().get()))
                .get();

        containerElement = Elements.div()
                .add(navElement = new BootstrapNav(mainElement))
                .add(mainElement)
                .get();
    }

    @Override
    public Nav getNavElement() {
        return navElement;
    }

    @Override
    public HTMLDivElement getContentElement() {
        return contentElement;
    }

    @Override
    public HTMLDivElement element() {
        return containerElement;
    }

}
