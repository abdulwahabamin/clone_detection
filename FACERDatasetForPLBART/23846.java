    private void savePreferences() {
        Log.d(TAG, "savePreferences() Entry.");

        if (musicSrv != null) {
            SharedPreferences.Editor editor = getSharedPreferences(SYMPHONY_PREFS_NAME, MODE_PRIVATE).edit();

            editor.putInt(SAVED_SHUFFLE_MODE, displayInfo.shuffle);

            int trkIndex = musicSrv.getTrackIndex();
            int trackPosition = musicSrv.getPosition();
            String genreName = musicSrv.getGenre();
            long trackSuffleSeed = musicSrv.getShuffleSeed();

            if (genreName != null)
                editor.putString(SAVED_GENRE_NAME, genreName);

            if (trkIndex >= 0)
                editor.putInt(SAVED_TRACK_INDEX, trkIndex);

            if (trackPosition > 0)
                editor.putInt(SAVED_TRACK_POSITION, trackPosition);

            if (trackSuffleSeed != 0)
                editor.putLong(SAVED_TRACK_SHUFFLE_SEED, trackSuffleSeed);
            editor.apply();
        }
    }

