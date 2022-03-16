    @Override
    public synchronized void previous() {
        if (mPlayListLen <= 0) return;

        if (mPlayPos > 0) {
            mPlayPos--;
        } else {
            mPlayPos = mPlayListLen - 1;
        }
        stop();
        prepareAndPlay(mPlayList[mPlayPos]);
    }

