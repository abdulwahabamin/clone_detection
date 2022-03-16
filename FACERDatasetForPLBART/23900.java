    private MediaPlayer initTrackPlayer() {
        Log.d(TAG, "initTrackPlayer() entry.");

        MediaPlayer newTrackPlayer = new MediaPlayer();
        //set currentTrackPlayer properties
        newTrackPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        newTrackPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        newTrackPlayer.setOnPreparedListener(this);
        newTrackPlayer.setOnCompletionListener(this);
        newTrackPlayer.setOnErrorListener(this);
        return newTrackPlayer;
    }

