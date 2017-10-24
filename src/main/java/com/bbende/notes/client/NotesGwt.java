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
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import org.fusesource.restygwt.client.Defaults;

/**
 * Main GWT Entry Point.
 *
 * @author bbende
 */
public class NotesGwt implements EntryPoint {

    public void onModuleLoad() {
        useCorrectRequestBaseUrl();

        final Label testLabel = new Label("Testing");
        RootPanel.get("notes").add(testLabel);
    }

    /**
     * Reference:
     *
     * https://github.com/feedm3/spring-boot-gwt/blob/master/src/main/java/com/codecrafters/client/SpringBootGwt.java
     */
    private void useCorrectRequestBaseUrl() {
        if (isDevelopmentMode()) {
            Defaults.setServiceRoot("http://localhost:8080");
        } else {
            Defaults.setServiceRoot(GWT.getHostPageBaseURL());
        }
    }

    /**
     * Detect if the app is in development mode.
     *
     * @return true if in development mode
     */
    private static native boolean isDevelopmentMode()/*-{
        return typeof $wnd.__gwt_sdm !== 'undefined';
    }-*/;

}
