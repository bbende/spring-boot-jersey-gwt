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
package com.bbende.notes.client;

import com.bbende.notes.client.layout.impl.BootstrapLayout;
import com.bbende.notes.client.layout.Layout;
import com.google.gwt.core.client.EntryPoint;
import elemental2.dom.DomGlobal;

/**
 * Main GWT Entry Point.
 *
 * @author bbende
 */
public class App implements EntryPoint {

    public void onModuleLoad() {
        // Create the layout and set it into the body of the document
        Layout layout = new BootstrapLayout();
        DomGlobal.document.body = layout.asElement();

        // Create the app controller and bind it to the content element of the layout
        AppController appController = new AppController();
        appController.bind(layout);
    }

}
