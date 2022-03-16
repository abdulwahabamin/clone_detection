    @Override
    public synchronized void play() {
        int result = mAudioManager.requestAudioFocus(mAudioFocusListener, AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN);
        if (result != AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            Log.w(TAG, "Unable to gain audio focus: " + result);
            return;
        }

        beforePlay();

        if (mPlayers[mCurrentPlayer].isInitialized()) {
            // if we are at the end of the song, go to the next song first
            long duration = mPlayers[mCurrentPlayer].duration();
            if (mRepeatMode != REPEAT_CURRENT && duration > NEXT_THRESHOLD_MILLIS &&
                    mPlayers[mCurrentPlayer].currentPosition() >= duration - NEXT_THRESHOLD_MILLIS) {
                next();
            }

            if (mSession != null) {
                activateMediaSession();
                updateMediaSession(true);
            }

            mPlayers[mCurrentPlayer].start();
            // make sure we fade in, in case a previous fadein was stopped because of another focus loss
            mPlaybackHander.removeMessages(DUCK);
            mPlaybackHander.removeMessages(FADEDOWN);
            mPlaybackHander.removeMessages(CROSSFADE);
            mPlaybackHander.sendMessage(mPlaybackHander.obtainMessage(FADEUP, mCurrentPlayer, 0));

            startForeground(PLAYBACKSERVICE_STATUS, buildNotification());

            if (!mIsSupposedToBePlaying) {
                mIsSupposedToBePlaying = true;
                notifyChange(PLAYSTATE_CHANGED);
            }
        }
    }

