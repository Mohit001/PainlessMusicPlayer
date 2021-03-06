/*
 * Copyright (C) 2017 Yaroslav Mytkalyk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.doctoror.fuckoffmusicplayer.presentation.home;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

/**
 * Data binding model for {@link RecentActivityFragment}
 */
public final class RecentActivityFragmentModel {

    private final ObservableInt displayedChild = new ObservableInt();
    private final ObservableField<RecyclerView.Adapter> recyclerAdapter = new ObservableField<>();

    @NonNull
    public ObservableInt getDisplayedChild() {
        return displayedChild;
    }

    @NonNull
    public ObservableField<RecyclerView.Adapter> getRecyclerAdapter() {
        return recyclerAdapter;
    }

    public void setRecyclerAdapter(@Nullable final RecyclerView.Adapter<?> adapter) {
        recyclerAdapter.set(adapter);
    }

    void setDisplayedChild(final int displayedChild) {
        this.displayedChild.set(displayedChild);
    }
}
