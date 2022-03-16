    public synchronized void playPrev() {
        Log.d(TAG, "playPrev() entry.");
        int prevSongIndex = -1;

        if (playingIndexInfo != null)
            prevSongIndex = playingIndexInfo.getPrevShuffleIndex();
        if (prevSongIndex >= 0) {
            playTrack(prevSongIndex);
        }
    }

