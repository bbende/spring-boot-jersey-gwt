
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
package com.bbende.notes.client.layout;

import elemental2.dom.HTMLAnchorElement;
import org.jboss.gwt.elemento.core.IsElement;

/**
 * A link in the Nav element.
 */
public interface NavLink extends IsElement<HTMLAnchorElement> {

    /**
     * @return the url token this link is for (excluding #)
     */
    String getUrlToken();

    /**
     * Adds the active css class to this link.
     */
    void activate();

    /**
     * Removes the active css class from this link.
     */
    void deactivate();

}
