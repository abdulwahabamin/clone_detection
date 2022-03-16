    private boolean stopPlayer() {
        Log.d(TAG, "stopPlayer():called");
        Log.i(TAG, "stopPlayer:state="+Playback.states[mState]);

        // already stopped?
        if (isStopped()) {
            return true;
        }

        // is playing or paused then only we can stop
        if (isPlaying() || isPaused()) {
            mMediaPlayer.stop();
            mState = Playback.CUSTOM_PLAYBACK_STATE_STOPPED;
            return true;
        }

        return false;
    }

