    public void setList(ArrayList<Song> theSongs, String theGenre) {
        Log.d(TAG, "setList() entry.");
        resetToInitialState();
        songs = theSongs;
        albums = Album.getAlbumIndexes(songs);
        songOrder = genPlayOrder(songs.size());
        shuffleSeed = lastShuffleSeed;
        albumOrder = genPlayOrder(albums.size());
        playingIndexInfo = null;
        onDeckIndexInfo = new IndexInfo();
        playListGenre = theGenre;
    }

