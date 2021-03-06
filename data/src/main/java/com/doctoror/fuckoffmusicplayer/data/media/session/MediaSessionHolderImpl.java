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
package com.doctoror.fuckoffmusicplayer.data.media.session;

import com.doctoror.fuckoffmusicplayer.data.concurrent.Handlers;
import com.doctoror.fuckoffmusicplayer.data.util.CollectionUtils;
import com.doctoror.fuckoffmusicplayer.domain.media.MediaSessionHolder;
import com.doctoror.fuckoffmusicplayer.domain.media.session.MediaSessionFactory;
import com.doctoror.fuckoffmusicplayer.domain.playback.PlaybackData;
import com.doctoror.fuckoffmusicplayer.domain.queue.Media;
import com.doctoror.fuckoffmusicplayer.domain.reporter.PlaybackReporter;
import com.doctoror.fuckoffmusicplayer.domain.reporter.PlaybackReporterFactory;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.media.session.MediaSessionCompat;

/**
 * {@link MediaSessionCompat} holder
 */
public final class MediaSessionHolderImpl implements MediaSessionHolder {

    private final MediaSessionFactory mediaSessionFactory;
    private final PlaybackData playbackData;
    private final PlaybackReporterFactory playbackReporterFactory;

    private volatile int openCount;

    private MediaSessionCompat mediaSession;

    public MediaSessionHolderImpl(
            @NonNull final MediaSessionFactory mediaSessionFactory,
            @NonNull final PlaybackData playbackData,
            @NonNull final PlaybackReporterFactory playbackReporterFactory) {
        this.mediaSessionFactory = mediaSessionFactory;
        this.playbackData = playbackData;
        this.playbackReporterFactory = playbackReporterFactory;
    }

    public void openSession() {
        synchronized (MediaSessionHolderImpl.class) {
            openCount++;
            if (openCount == 1) {
                doOpenSession();
            }
        }
    }

    public void closeSession() {
        synchronized (MediaSessionHolderImpl.class) {
            openCount--;
            if (openCount == 0) {
                doCloseSession();
            }
        }
    }

    private void doOpenSession() {
        this.mediaSession = mediaSessionFactory.newMediaSession();
        Handlers.runOnIoThread(() -> reportMediaAndState(mediaSession));
    }

    private void doCloseSession() {
        if (mediaSession != null) {
            mediaSession.setActive(false);
            mediaSession.release();
            mediaSession = null;
        }
    }

    @Nullable
    public MediaSessionCompat getMediaSession() {
        return mediaSession;
    }

    @WorkerThread
    private void reportMediaAndState(@NonNull final MediaSessionCompat mediaSession) {
        final PlaybackReporter playbackReporter = playbackReporterFactory
                .newMediaSessionReporter(mediaSession);

        final int position = playbackData.getQueuePosition();
        final Media current = CollectionUtils.getItemSafe(playbackData.getQueue(), position);
        if (current != null) {
            playbackReporter.reportTrackChanged(current, position);
        }
        playbackReporter.reportPlaybackStateChanged(playbackData.getPlaybackState(), null);
    }
}
