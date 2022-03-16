    private void connectToSession(MediaSessionCompat.Token token) throws RemoteException {
        MediaControllerCompat mediaController = new MediaControllerCompat(
                NowPlayingActivity.this, token);
        if (mediaController.getMetadata() == null) { // metadata = null when no media is playing
            finish();
            return;
        }
        MediaControllerCompat.setMediaController(NowPlayingActivity.this, mediaController);
        mediaController.registerCallback(mediaControllerCallback);

        PlaybackStateCompat state = mediaController.getPlaybackState();
        updatePlaybackState(state);
        MediaMetadataCompat metadata = mediaController.getMetadata();
        if (metadata != null) {
            updateMediaDescription(metadata.getDescription());
            updateDuration(metadata);
        }
        updateProgress();
        if (state != null && (state.getState() == PlaybackStateCompat.STATE_PLAYING ||
                state.getState() == PlaybackStateCompat.STATE_BUFFERING)) {
            scheduleSeekbarUpdate();
        }
    }

