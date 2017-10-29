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
import com.bbende.notes.client.service.NotesService;
import com.bbende.notes.client.view.NotesListView;
import com.bbende.notes.client.view.NotesListViewImpl;
import com.bbende.notes.shared.Note;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Label;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

/**
 * @author bbende
 */
public class NotesListActivity extends Activity {

    public NotesListActivity(ClientFactory clientFactory) {
        super(clientFactory);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        final Activity listener = this;
        final NotesService notesService = getClientFactory().getNotesService();

        notesService.getAll(new MethodCallback<List<Note>>() {
            @Override
            public void onFailure(Method method, Throwable exception) {
                panel.setWidget(new Label("Error Retrieving Notes: " + exception.getMessage()));
            }

            @Override
            public void onSuccess(Method method, List<Note> response) {
                NotesListView notesListView = new NotesListViewImpl(response);
                notesListView.setActivity(listener);
                panel.setWidget(notesListView.asWidget());
            }
        });

    }
}
