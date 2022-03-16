    private void seekPlayerTo(int position) {
        Log.d(TAG, "seekPlayerTo():called");
        Log.i(TAG, "seekPlayerTo:state="+Playback.states[mState]);
        // if playing or paused then only we can seek player
        if (isPlaying() || isPaused()) {
            mMediaPlayer.seekTo(position);
        } else {
            if (isStopped()) {
                preparePlayer();
            } else {
                //do nothing
            }
        }
    }

