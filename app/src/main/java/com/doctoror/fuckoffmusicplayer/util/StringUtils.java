/*
 * Copyright (C) 2016 Yaroslav Mytkalyk
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
package com.doctoror.fuckoffmusicplayer.util;

import com.doctoror.fuckoffmusicplayer.R;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

public final class StringUtils {

    private StringUtils() {

    }

    @NonNull
    public static String capWords(@NonNull final String input) {
        boolean prevWasWhiteSp = true;
        final char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (prevWasWhiteSp) {
                    chars[i] = Character.toUpperCase(chars[i]);
                }
                prevWasWhiteSp = false;
            } else {
                prevWasWhiteSp = Character.isWhitespace(chars[i]);
            }
        }
        return new String(chars);
    }

    @NonNull
    public static String notNullString(@Nullable final String string) {
        return string != null ? string : "";
    }

    @NonNull
    public static String formatArtistAndAlbum(@NonNull final Resources res,
            @Nullable String artist,
            @Nullable String album) {
        if (TextUtils.isEmpty(artist)) {
            artist = res.getString(R.string.Unknown_artist);
        }
        if (TextUtils.isEmpty(album)) {
            album = res.getString(R.string.Unknown_album);
        }
        return artist + res.getString(R.string.artist_album_separator) + album;
    }
}


