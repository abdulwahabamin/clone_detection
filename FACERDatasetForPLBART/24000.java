    private void addToPlaylistInternal(long[] list, int position) {
        if (position < 0) { // overwrite
            mPlayListLen = 0;
            position = 0;
        }
        ensurePlayListCapacity(mPlayListLen + list.length);
        if (position > mPlayListLen) {
            position = mPlayListLen;
        }

        // move part of list after insertion point
        int tailsize = mPlayListLen - position;
        if (tailsize > 0) System.arraycopy(mPlayList, position, mPlayList, position + list.length, tailsize);

        // copy list into playlist
        System.arraycopy(list, 0, mPlayList, position, list.length);
        mPlayListLen += list.length;
    }

