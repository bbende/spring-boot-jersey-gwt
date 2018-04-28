/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bbende.notes.client;

import com.google.gwt.core.client.EntryPoint;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLParagraphElement;
import org.gwtproject.user.history.client.History;
import org.jboss.gwt.elemento.core.Elements;

import static org.jboss.gwt.elemento.core.Elements.*;

/**
 * Main GWT Entry Point.
 *
 * @author bbende
 */
public class App implements EntryPoint {

    public void onModuleLoad() {
        HTMLDivElement contentContainer = div().asElement();

        Elements.body()
                .add(p().textContent("BODY"))
                .add(contentContainer);

        AppController appController = new AppController(contentContainer);
        History.fireCurrentHistoryState();
    }

}
