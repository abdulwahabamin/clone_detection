    @Override
    public synchronized int getCrossfadeQueuePosition() {
        if (mPlayPos >= 0 && mPlayers[mNextPlayer].isPlaying()) {
            return mPlayPos + 1;
        } else {
            return -1;
        }
    }

