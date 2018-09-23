
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

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLLIElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

@Templated
public abstract class TopNavLink implements IsElement<HTMLLIElement> {

    public static TopNavLink create(String text, String href) {
        return new Templated_TopNavLink(text, href);
    }

    public abstract String getText();

    public abstract String getHref();

    @DataElement
    HTMLAnchorElement anchorElement;

    public HTMLAnchorElement getAnchorElement() {
        return this.anchorElement;
    }

}
