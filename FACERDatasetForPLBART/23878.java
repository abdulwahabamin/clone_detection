    @Override
    public synchronized void onPrepared(MediaPlayer mp) {
        Log.d(TAG, "onPrepared() entry.");
        // Register a receiver to be notified about headphones being
        // unplugged then start playback
        if (currentTrackPlayer == mp) {
            Log.d(TAG, "onPrepared() Unexpected event on currentTrackPlayer");
        } else if (onDeckTrackPlayer == mp) {
            if (currentTrackPlayer == null) {
                //
                // No currently playing track. Set the on deck track to currently playing
                //
                currentTrackPlayer = onDeckTrackPlayer;
                playingIndexInfo = onDeckIndexInfo;
                onDeckTrackPlayer = null;

                if (deferredPosition > 0)
                    currentTrackPlayer.seekTo(deferredPosition);
                deferredPosition = -1;

                if (deferredGo)
                    this.go();
                else
                    tellTheWorld(SERVICE_PAUSED);

                // Setup an "on Deck" player for the next track to play
                onDeckIndexInfo = new IndexInfo(playingIndexInfo);
                onDeckTrackPlayer = prepareTrack(onDeckIndexInfo.getTrackIndex());
            } else {
                // We are currently playing a track. Set the on deck track to play when
                // current track is done.
                currentTrackPlayer.setNextMediaPlayer(onDeckTrackPlayer);
            }
        }
    }

