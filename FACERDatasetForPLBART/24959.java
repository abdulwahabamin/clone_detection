    private void populateSongs() {
        songs = DTOConverter.getSongList(MusicDataUtility.getSongsFromList(musicContent, this));
        songListAdapter.updateSongs(songs);
        if (songs.size() > 0) {
            findViewById(R.id.no_songs_added).setVisibility(View.GONE);
        } else {
            findViewById(R.id.no_songs_added).setVisibility(View.VISIBLE);
        }
    }

