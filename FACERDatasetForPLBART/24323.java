    protected void selectedPlaylist(MenuItem item) {
        long playlist = item.getIntent().getLongExtra("playlist", 0);
        long[] songs = fetchSongList(mCurrentId);
        if (shuffleSongs()) MusicUtils.shuffleArray(songs);
        MusicUtils.addToPlaylist(getActivity(), songs, playlist);
    }

