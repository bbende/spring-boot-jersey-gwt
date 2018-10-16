
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
package com.bbende.notes.client.ui.layout;

import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

/**
 * Navigation element for the layout.
 */
public interface Nav extends IsElement<HTMLElement> {

    /**
     * Notifies the Nav element about changes to the url token.
     *
     * @param urlToken the new url token
     */
    void onHistoryChange(String urlToken);

}
