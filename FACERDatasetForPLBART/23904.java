    private void updateMetaData() {
        Log.d(TAG, "updateMetaData() entry.");
        if ((currentTrackPlayer != null) && (playingIndexInfo != null)) {
            Song songToPlay = songs.get(playingIndexInfo.getTrackIndex());    //get song info

            String trackTitle = songToPlay.getTitle();            //set title
            String trackAlbum = songToPlay.getAlbum();
            String trackArtist = songToPlay.getArtist();
            Bitmap trackArtwork = songToPlay.getArtwork(getApplicationContext());

            // Update the current metadata
            mediaSession.setMetadata(new MediaMetadata.Builder()
                    .putBitmap(MediaMetadata.METADATA_KEY_ALBUM_ART, trackArtwork)
                    .putString(MediaMetadata.METADATA_KEY_ARTIST, trackArtist)
                    .putString(MediaMetadata.METADATA_KEY_ALBUM, trackAlbum)
                    .putString(MediaMetadata.METADATA_KEY_TITLE, trackTitle)
                    .build());

            Log.d(TAG, "updateMetaData() trackAlbum=" + trackAlbum);
            Log.d(TAG, "updateMetaData() trackTitle=" + trackTitle);
            Log.d(TAG, "updateMetaData() trackArtist=" + trackArtist);
        }
    }

