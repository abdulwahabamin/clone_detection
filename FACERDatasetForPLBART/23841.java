    private void setDisplayGenre(int Position) {
        Log.d(TAG, "setDisplayGenre(" + Position + ") Entry.");
        Genre selectedGenre = genres.get(Position);
        ArrayList<Song> genrePlaylist;

        if ((selectedGenre != null) &&
                (displayInfo != null)) {

            // If this is the first time the genre has been selected then
            // the play list will be undefined. So build the list on first
            // use.
            genrePlaylist = selectedGenre.getPlaylist();
            if ((genrePlaylist == null) || genrePlaylist.isEmpty()) {
                genrePlaylist = getGenreSongs(selectedGenre.getId());
                selectedGenre.setPlaylist(genrePlaylist);
            }
            currentDisplayPlayList.clear();
            currentDisplayPlayList.addAll(genrePlaylist);

            ArrayList<Album> genreAlbums = Album.getAlbumIndexes(genrePlaylist);

            currentDisplayAlbums.clear();
            if (genreAlbums != null)
                currentDisplayAlbums.addAll(genreAlbums);
            if (albumAdaptor != null)
                albumAdaptor.notifyDataSetChanged();

            if (!selectedGenre.getName().equals(displayInfo.genreName)) {
                displayInfo.trackId = 0;
            }

            //
            // If we are changing to the genre that is currently playing
            // then select the track and track album currently playing.
            // Otherwise select the first track (and its album) in the genre.
            //
            if ((playingInfo != null) &&
                    playingInfo.genreName.equals(selectedGenre.getName()) &&
                    (musicSrv != null)) {
                displayInfo.trackId = Math.max(0, musicSrv.getTrackIndex());
            }
            displayInfo.genreName = selectedGenre.getName();
            songAdt.notifyDataSetChanged();

            selectDisplayAlbum(displayInfo.trackId);
            songView.setSelection(displayInfo.trackId);
        }
    }

