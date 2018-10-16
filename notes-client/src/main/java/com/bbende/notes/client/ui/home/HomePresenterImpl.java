
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
package com.bbende.notes.client.ui.home;

import com.bbende.notes.client.mvp.AbstractPresenter;

public class HomePresenterImpl extends AbstractPresenter<HomeView> implements HomePresenter {

    private String message;

    public HomePresenterImpl(final HomeView view, final String message) {
        super(view);
        this.message = message;
        onMessageChange();
    }

    @Override
    public void onNewMessageClicked() {
        this.message = "The time is " + System.currentTimeMillis();
        onMessageChange();
    }

    private void onMessageChange() {
        this.view.setMessage(message);
    }

}
