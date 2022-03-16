    public void songPicked(View view) {
        // Note to self: song.xml in layouts specifies this method to be called when
        // a song is touched.
        Log.d(TAG, "songPicked() entry. Selected item = " + view.toString());
        int selectedItem = Integer.parseInt(view.getTag().toString());
        Log.d(TAG, "songPicked() selected= " + selectedItem);
        displayInfo.trackId = Integer.parseInt(view.getTag().toString());
        if (!displayInfo.genreName.equals(playingInfo.genreName)) {
            Genre myGenre = getGenreByName(displayInfo.genreName);
            if (myGenre != null) {
                musicSrv.setList(myGenre.getPlaylist(), myGenre.getName());
                playingInfo.genreName = displayInfo.genreName;
                playingInfo.trackId = displayInfo.trackId;
            }
        }
        musicSrv.playTrack(displayInfo.trackId);
        startSeekTracking();
        updateControls();
    }

