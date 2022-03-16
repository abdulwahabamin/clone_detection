    private MediaPlayer prepareTrack(int trackIndex) {
        if ((songs == null) && (trackIndex < songs.size()))
            return null;
        MediaPlayer mp = initTrackPlayer();
        Song songToPlay = songs.get(trackIndex);    //get song info
        long currSong = songToPlay.getId();           //set uri

        Uri trackUri = ContentUris.withAppendedId(
                android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                currSong);
        try {
            mp.setDataSource(getApplicationContext(), trackUri);
        } catch (Exception e) {
            Log.e("MUSIC SERVICE", "Error setting data source", e);
            mp.release();
            return null;
        }
        mp.prepareAsync();
        return mp;
    }

