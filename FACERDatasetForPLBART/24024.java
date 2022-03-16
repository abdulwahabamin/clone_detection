    @Override
    public synchronized void next() {
        if (mPlayListLen <= 0) return;

        if (mPlayPos >= mPlayListLen - 1) {
            // we're at the end of the list
            mPlayPos = 0;
        } else {
            mPlayPos++;
        }
        stop();
        prepareAndPlay(mPlayList[mPlayPos]);
    }

