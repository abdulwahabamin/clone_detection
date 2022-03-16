    private void selectDisplayAlbum(int trackId) {
        Log.d(TAG, "selectDisplayAlbum(" + trackId + ") Entry.");
        Song displaySong = getTrackInfo(trackId);
        if (displaySong != null) {
            String albumTitle = displaySong.getAlbum();

            for (int i = 0; i < currentDisplayAlbums.size(); i++) {

                if (currentDisplayAlbums.get(i).getTitle().compareTo(albumTitle) == 0) {
                    albumSpinner.setSelection(i);
                    return;
                }
            }
        }
    }

