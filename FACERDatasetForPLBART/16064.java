    @Override
    public void onSongStarted(Song song) {
        showPause();
        if(song != currentSong) {
            currentSong = song;
            changeSongInfo(song, rootView);
        }
    }

