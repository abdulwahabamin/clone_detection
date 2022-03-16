    private void ensurePlayListCapacity(int size) {
        if (size > mPlayList.length) {
            // reallocate at 2x requested size so we don't
            // need to grow and copy the array for every
            // insert
            long[] newlist = new long[size * 2];
            System.arraycopy(mPlayList, 0, newlist, 0, mPlayList.length);
            mPlayList = newlist;
        }
        // FIXME: shrink the array when the needed size is much smaller
        // than the allocated size
    }

