
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
package com.bbende.notes.client.ui.add;

import com.bbende.notes.client.ApplicationController;
import com.bbende.notes.client.mvp.AbstractPresenter;
import org.gwtproject.user.history.client.History;

public class AddNotePresenterImpl extends AbstractPresenter<AddNoteView>
        implements AddNotePresenter {

    public AddNotePresenterImpl(final AddNoteView view) {
        super(view);
    }

    @Override
    public void onAddClicked() {
        final String noteText = view.getNoteText().value;

        History.newItem(ApplicationController.TOKEN_LIST);
        History.fireCurrentHistoryState();
    }

}
