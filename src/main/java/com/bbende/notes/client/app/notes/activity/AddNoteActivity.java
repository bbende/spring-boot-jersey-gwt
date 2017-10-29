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
package com.bbende.notes.client.app.notes.activity;

import com.bbende.notes.client.ClientFactory;
import com.bbende.notes.client.app.notes.view.AddNoteView;
import com.bbende.notes.client.app.notes.view.AddNoteViewImpl;
import com.bbende.notes.client.mvp.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author bbende
 */
public class AddNoteActivity extends Activity {

    public AddNoteActivity(ClientFactory clientFactory) {
        super(clientFactory);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        AddNoteView notesAddView = new AddNoteViewImpl();
        notesAddView.setActivity(this);
        panel.setWidget(notesAddView.asWidget());
    }
}
