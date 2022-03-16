    @Override
    public synchronized void setQueuePosition(int pos) {
        if (pos > mPlayListLen - 1) return;
        stop();
        mPlayPos = pos;
        prepareAndPlay(mPlayList[mPlayPos]);
    }

