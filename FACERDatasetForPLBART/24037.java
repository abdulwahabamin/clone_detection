    @Override
    public synchronized long getCrossfadeAudioId() {
        if (mPlayPos >= 0 && mPlayers[mNextPlayer].isPlaying()) {
            return mPlayList[mPlayPos + 1];
        } else {
            return -1;
        }
    }

