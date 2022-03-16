    @Override
    public synchronized void uniqueify() {
        if (!isPlaying()) {
            boolean modified = false;
            Set<Long> found = new HashSet<>();
            for (int i = mPlayListLen - 1; i >= 0; i--) {
                if (!found.add(mPlayList[i])) {
                    removeTracksInternal(i, i);
                    modified = true;
                }
            }
            if (modified) {
                notifyChange(QUEUE_CHANGED);
            }
        }
    }

