    @Override
    public void onSongStarted(Song song) {
        if(currentSong != song) {
            currentSong = song;
            changeTrackInfo(song);
        }
        
        showPause();
    }

