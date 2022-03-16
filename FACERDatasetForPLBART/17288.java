    /**
     * Update the current media player state, optionally showing an error message.
     * @param error if not null, error message to present to the user.
     */
    public void updatePlaybackState(String error) {
        Log.d(TAG, "updatePlaybackState:called");
        Log.i(TAG, "updatePlaybackState:playbackState=" + mPlayback.getState());

        long position = PlaybackStateCompat.PLAYBACK_POSITION_UNKNOWN;
        if (mPlayback != null) {
            position = mPlayback.getCurrentPosition();
        }

        Log.i(TAG, "updatePlaybackState:position="+position);

        //noinspection ResourceType
        PlaybackStateCompat.Builder stateBuilder = new PlaybackStateCompat.Builder()
                .setActions(getAvailableActions());

        int state = mPlayback.getState();

        // setting appropriate state
        if (state == Playback.CUSTOM_PLAYBACK_STATE_PAUSED) {
            state = PlaybackStateCompat.STATE_PAUSED;
        } else if (state == Playback.CUSTOM_PLAYBACK_STATE_PLAYING) {
            state = PlaybackStateCompat.STATE_PLAYING;
        } else if (state == Playback.CUSTOM_PLAYBACK_STATE_STOPPED) {
            state = PlaybackStateCompat.STATE_STOPPED;
        } else {
            state = PlaybackStateCompat.STATE_NONE;
        }

        // If there is an error message, send it to the playback state:
        if (error != null) {
            // Error states are really only supposed to be used for errors that cause playback to
            // stop unexpectedly and persist until the user takes action to fix it.
            stateBuilder.setErrorMessage(0, error);
            state = PlaybackStateCompat.STATE_ERROR;
        }
        //noinspection ResourceType
        stateBuilder.setState(state, position, 1.0f, SystemClock.elapsedRealtime());

        Bundle b = new Bundle();
        b.putInt(Playback.PLAYBACK_STATE_EXTRA_CURRENT_QUEUE_INDEX,
                mQueueManager.getmCurrentQueueIndex());

        // Set the activeQueueItemId if the current index is valid.
        MediaSessionCompat.QueueItem currentMusic = mQueueManager.getCurrentMusic();
        if (currentMusic != null) {
            stateBuilder.setActiveQueueItemId(currentMusic.getQueueId());

            // todo temp
            Log.w(TAG, "updatePlaybackState:"+QueueHelper.getMusicIdOf(currentMusic));
            Log.w(TAG, "updatePlaybackState:"+mPlaylistsManager.isSongInFavourites(QueueHelper.getMediaIdOf(currentMusic)));

            b.putBoolean(PlaylistsSource.PLAYBACK_STATE_EXTRA_IS_IN_FAVORITES,
                    mPlaylistsManager.isSongInFavourites(QueueHelper.getMusicIdOf(currentMusic)));
        }

        stateBuilder.setExtras(b);

        mServiceCallback.onPlaybackStateUpdated(stateBuilder.build());

        // tell service that notification is required
        if (state == PlaybackStateCompat.STATE_PLAYING) {
            mServiceCallback.onNotificationRequired();
        }
    }

