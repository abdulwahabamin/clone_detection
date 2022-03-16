    /**
     * Returns the rowid of the currently playing file, or -1 if
     * no file is currently playing.
     */
    public int getAudioId() {
        synchronized (this) {
            if (mPlayPos >= 0 && (mServiceInUse || mPlayer.isInitialized())) {
                return mPlayList[mPlayPos];
            }
        }
        return -1;
    }

