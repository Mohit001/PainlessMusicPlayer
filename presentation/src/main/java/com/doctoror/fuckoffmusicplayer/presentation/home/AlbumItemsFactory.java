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

import android.database.Cursor;
import android.support.annotation.NonNull;

import com.doctoror.fuckoffmusicplayer.domain.albums.AlbumsProvider;

import java.util.ArrayList;
import java.util.List;

final class AlbumItemsFactory {

    private AlbumItemsFactory() {
        throw new UnsupportedOperationException();
    }

    static List<AlbumItem> itemsFromCursor(@NonNull final Cursor c) {
        final List<AlbumItem> items = new ArrayList<>(c.getCount());
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            items.add(itemFromCursor(c));
        }
        return items;
    }

    @NonNull
    private static AlbumItem itemFromCursor(@NonNull final Cursor c) {
        final AlbumItem item = new AlbumItem();
        item.id = c.getLong(AlbumsProvider.COLUMN_ID);
        item.title = c.getString(AlbumsProvider.COLUMN_ALBUM);
        item.albumArt = c.getString(AlbumsProvider.COLUMN_ALBUM_ART);
        return item;
    }
}
