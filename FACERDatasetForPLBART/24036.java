    @Override
    public synchronized long getAudioId() {
        if (mPlayPos >= 0 && mPlayers[mCurrentPlayer].isInitialized()) {
            return mPlayList[mPlayPos];
        } else {
            return -1;
        }
    }

