    private PlayInfo restorePreferences() {
        Log.d(TAG, "restorePreferences() Entry.");
        PlayInfo saved = new PlayInfo();

        SharedPreferences prefs = getSharedPreferences(SYMPHONY_PREFS_NAME, MODE_PRIVATE);

        saved.genreName = prefs.getString(SAVED_GENRE_NAME, null);
        saved.shuffle = prefs.getInt(SAVED_SHUFFLE_MODE, MusicService.PLAY_SEQUENTIAL);
        saved.trackId = prefs.getInt(SAVED_TRACK_INDEX, -1);
        saved.position = prefs.getInt(SAVED_TRACK_POSITION, 0);
        saved.shuffleSeed = prefs.getLong(SAVED_TRACK_SHUFFLE_SEED, 0);

        if ((saved.genreName == null) || (saved.trackId < 0))
            return null;
        return saved;
    }

