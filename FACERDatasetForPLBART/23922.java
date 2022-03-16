    @Override
    protected Object[] doInBackground(Object... params) {
        String playlistName = (String)params[0];
        long playlistId = (Long)params[1];
        boolean shouldShare = (Boolean)params[2];

        String musicDir = PreferenceManager.getDefaultSharedPreferences(context).getString(
                SettingsActivity.MUSIC_FOLDER,
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());

        File file = shouldShare
                ? new File(context.getExternalCacheDir(), playlistName+".m3u")
                : new File(musicDir, playlistName+".txt");

        export(playlistId, musicDir.length()+1, file);

        return new Object[] { file, shouldShare };
    }

