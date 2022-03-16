    @Override
    public synchronized void enqueue(long[] list, int action) {
        if (list.length == 0) return;

        if ((action == NEXT || action == NOW) && mPlayPos + 1 < mPlayListLen) {
            addToPlayList(list, mPlayPos + 1);
            if (action == NOW) {
                stop();
                mPlayPos++;
                prepareAndPlay(mPlayList[mPlayPos]);
                return;
            }
        } else {
            addToPlayList(list, Integer.MAX_VALUE);
            if (action == NOW) {
                stop();
                mPlayPos = mPlayListLen - list.length;
                prepareAndPlay(mPlayList[mPlayPos]);
                return;
            }
        }
        if (mPlayPos < 0) {
            stop();
            mPlayPos = 0;
            prepareAndPlay(mPlayList[mPlayPos]);
        }
    }

