    private void setMusicFolder(String folder) {
        if (new File(folder).isDirectory()) {
            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
            editor.putString(SettingsActivity.MUSIC_FOLDER, folder);
            editor.apply();

            if (!MusicUtils.android44OrLater()) {
                Log.i(LOGTAG, "Rescanning music");
                sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.fromFile(Environment.getExternalStorageDirectory())));
            }
        }
    }

