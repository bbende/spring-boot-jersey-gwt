
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

import com.bbende.notes.client.layout.Layout;
import com.bbende.notes.client.layout.Nav;
import elemental2.dom.HTMLBodyElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;

import static org.jboss.gwt.elemento.core.Elements.*;
import static com.bbende.notes.client.util.Roles.*;

/**
 * Dashboard layout from bootstrap-material examples.
 */
public class BootstrapLayout implements Layout {

    public static final String MAIN_TAG = "main";

    private Nav navElement;
    private HTMLElement mainElement;
    private HTMLDivElement contentElement;
    private HTMLBodyElement bodyElement;

    public BootstrapLayout() {
        mainElement = htmlElement(MAIN_TAG, HTMLElement.class)
                .attr(ROLE_ATTR, ROLE_MAIN)
                .add(div().add(contentElement = div().asElement()))
                .asElement();

        bodyElement = body()
                .add(navElement = new BootstrapNav(mainElement))
                .add(mainElement)
                .asElement();
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
    public HTMLBodyElement asElement() {
        return bodyElement;
    }

}
