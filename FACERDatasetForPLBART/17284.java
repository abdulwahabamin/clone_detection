    @SuppressWarnings("WeakerAccess")
    public void handlePlayRequest(){
        Log.d(TAG, "handlePlayRequest:called");
        Log.i(TAG, "handlePlayRequest:mState=" + Playback.states[mPlayback.getState()]);

        MediaSessionCompat.QueueItem currentMusic = mQueueManager.getCurrentMusic();
        if (currentMusic != null) {
            if (mPlayback.play(currentMusic)){
                // tell service that playback started
                mServiceCallback.onPlaybackStart();
            }
        }
    }

