    @Override
    public synchronized void seek(long pos) {
        if (mPlayers[mCurrentPlayer].isInitialized()) {
            mPlaybackHander.removeMessages(DUCK);
            mPlaybackHander.removeMessages(FADEUP);
            mPlaybackHander.removeMessages(FADEDOWN);
            mPlaybackHander.removeMessages(CROSSFADE);
            if (pos < 0) pos = 0;
            if (pos > mPlayers[mCurrentPlayer].duration()) pos = mPlayers[mCurrentPlayer].duration();
            mPlayers[mCurrentPlayer].seek(pos);

            if (mIsSupposedToBePlaying) {
                scheduleFadeOut();
            }
        }
    }

