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
package com.bbende.notes.client.activity;

import com.bbende.notes.client.ClientFactory;
import com.bbende.notes.client.view.HomeView;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author bbende
 */
public class HomeActivity extends Activity {

    public HomeActivity(ClientFactory clientFactory) {
        super(clientFactory);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        final HomeView homeView = getClientFactory().getHomeView();
        homeView.setActivity(this);
        panel.setWidget(homeView.asWidget());
    }

    @Override
    public String mayStop() {
        return "Please hold on. This activity is stopping.";
    }

    @Override
    public void onCancel() {
        super.onCancel();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
