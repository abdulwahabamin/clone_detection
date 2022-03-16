    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");

        // Check that we're not being destroyed while something is still playing.
        if (isPlaying()) {
            Log.e(TAG, "Service being destroyed while still playing.");
        }

        additionalDestroy();

        if (mSession != null) {
            releaseMediaSession();
        }

        for (MyMediaPlayer player : mPlayers) player.release();

        mAudioManager.abandonAudioFocus(mAudioFocusListener);

        // make sure there aren't any other messages coming
        mDelayedStopHandler.removeCallbacksAndMessages(null);
        mPlaybackHander.removeCallbacksAndMessages(null);

        unregisterReceiver(mIntentReceiver);
        unregisterReceiver(mUnmountReceiver);

        super.onDestroy();
    }

