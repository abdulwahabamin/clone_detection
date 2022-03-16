    public synchronized Song getCurrentSong() {
        if ((currentTrackPlayer != null) && (playingIndexInfo != null)) {
            return songs.get(playingIndexInfo.getTrackIndex());    //get song info
        }
        return null;
    }

