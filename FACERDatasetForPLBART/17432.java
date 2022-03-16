    @Override
    public void onSeekComplete(MediaPlayer mp) {
        Log.d(TAG, "onSeekComplete:called");
        Log.d(TAG, "onSeekComplete:positionAfterSeek="+getCurrentPosition());

        // store the resume position
        mResumePosition = mMediaPlayer.getCurrentPosition();

        // tell playback manager about the state so that the
        // ui can be updated with new seekbar position
        if (isPlaying()) {
            mCallback.onPlaybackStatusChanged(mState);
        } else if (isPaused()) {
            mCallback.onPlaybackStatusChanged(mState);
        }

    }

