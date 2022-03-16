    public boolean removeItem(int which) {
        if (service.removeTracks(which, which) == 0) {
            return false; // delete failed
        }
        int i = which;
        mSize--;
        while (i < mSize) {
            playQueue[i] = playQueue[i + 1];
            i++;
        }
        onMove(-1, mCurPos);
        return true;
    }

