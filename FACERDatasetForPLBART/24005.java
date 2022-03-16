    @Override
    public synchronized void load(long[] list, int position) {
        int listlength = list.length;
        boolean newlist = true;
        if (mPlayListLen == listlength) {
            // possible fast path: list might be the same
            newlist = false;
            for (int i = 0; i < listlength; i++) {
                if (list[i] != mPlayList[i]) {
                    newlist = true;
                    break;
                }
            }
        }
        if (newlist) {
            addToPlayList(list, -1);
        }
        if (position >= 0) {
            mPlayPos = position;
        } else {
            mPlayPos = 0;
        }

        stop();
        prepareAndPlay(mPlayList[mPlayPos]);
    }

