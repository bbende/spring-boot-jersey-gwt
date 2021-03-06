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
package com.bbende.notes.client.mvp;

import com.bbende.notes.client.ClientFactory;
import com.bbende.notes.client.app.notes.activity.AddNoteActivity;
import com.bbende.notes.client.app.notes.activity.ListNotesActivity;
import com.bbende.notes.client.app.notes.place.AddNotePlace;
import com.bbende.notes.client.app.notes.place.ListNotesPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

/**
 * Maps Places to Activities.
 *
 * @author bbende
 */
public class AppActivityMapper implements ActivityMapper {

    private ClientFactory clientFactory;

    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof ListNotesPlace) {
            return new ListNotesActivity(clientFactory);
        } else if (place instanceof AddNotePlace) {
            return new AddNoteActivity(clientFactory);
        } else {
            return null;
        }
    }

}
