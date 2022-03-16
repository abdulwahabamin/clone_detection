    @Override
    public synchronized void onCompletion(MediaPlayer mp) {
        Log.d(TAG, "onCompletion() entry.");
        if ((currentTrackPlayer != null) && (currentTrackPlayer.getCurrentPosition() > 0)) {
            currentTrackPlayer.reset();
            currentTrackPlayer.release();
            currentTrackPlayer = onDeckTrackPlayer;
            onDeckTrackPlayer = null;
            if (currentTrackPlayer != null) {
                Log.d(TAG, "onCompletion() next track prepared, starting immediately.");
                playingIndexInfo = onDeckIndexInfo;
                tellTheWorld(SERVICE_NOW_PLAYING);

                // Setup an "on Deck" player for the next track to play
                onDeckIndexInfo = new IndexInfo(playingIndexInfo);
                onDeckTrackPlayer = prepareTrack(onDeckIndexInfo.getTrackIndex());
            }
        }
    }

