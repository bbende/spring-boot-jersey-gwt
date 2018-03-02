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
package com.bbende.notes.client.app.notes.view;

import com.bbende.notes.client.mvp.AbstractView;
import com.bbende.notes.shared.Note;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconPosition;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCollection;
import gwt.material.design.client.ui.MaterialCollectionItem;
import gwt.material.design.client.ui.MaterialCollectionSecondary;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialDivider;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRow;

import java.util.List;

/**
 * @author bbende
 */
public class ListNotesViewImpl extends AbstractView implements ListNotesView {

    public ListNotesViewImpl(List<Note> notes) {
        MaterialPanel notesPanel = new MaterialPanel();
        //notesPanel.setContainerEnabled(true);

        MaterialCollection notesCollection = new MaterialCollection();

        for(Note note : notes) {
            MaterialLabel noteLabel = new MaterialLabel();
            noteLabel.setText(note.getText());

            MaterialIcon deleteIcon = new MaterialIcon();
            deleteIcon.setIconPosition(IconPosition.RIGHT);
            deleteIcon.setIconType(IconType.DELETE);
            deleteIcon.setIconColor(Color.GREY_DARKEN_1);
            deleteIcon.setWaves(WavesType.DEFAULT);

            MaterialCollectionSecondary deleteSecondary = new MaterialCollectionSecondary();
            deleteSecondary.add(deleteIcon);

            MaterialCollectionItem noteItem = new MaterialCollectionItem();
            noteItem.add(noteLabel);
            noteItem.add(deleteSecondary);

            notesCollection.add(noteItem);
        }

        notesPanel.add(notesCollection);

        initWidget(notesPanel);
    }

}
