/*
 * Copyright (C) 2018 Yaroslav Mytkalyk
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
package com.doctoror.fuckoffmusicplayer.parcelable.converter;

import android.databinding.ObservableInt;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.parceler.ParcelConverter;

public final class ObservableIntConverter implements ParcelConverter<ObservableInt> {

    @Override
    public void toParcel(@Nullable final ObservableInt input, @NonNull final Parcel parcel) {
        parcel.writeInt(input != null ? input.get() : 0);
    }

    @Override
    public ObservableInt fromParcel(@NonNull final Parcel parcel) {
        return new ObservableInt(parcel.readInt());
    }
}
