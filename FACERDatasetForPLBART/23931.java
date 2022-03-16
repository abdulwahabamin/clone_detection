    private CharSequence importPlaylist(String name, Uri playlistToImport) {
        Log.i(LOGTAG, "Importing playlist: " + name);

        if (MusicUtils.playlistExists(context, name)) {
            return context.getString(R.string.playlist_already_exists);
        }

        ArrayList<Long> songIds = new ArrayList<>();
        String musicDir = PreferenceManager.getDefaultSharedPreferences(context).getString(
                SettingsActivity.MUSIC_FOLDER,
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());

        InputStream is = null;
        try {
            is = context.getContentResolver().openInputStream(playlistToImport);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                parseLine(musicDir, songIds, line);
            }
        } catch (IOException e) {
            Log.w(LOGTAG, "Unable to read playlist: " + playlistToImport.toString(), e);
            MusicUtils.reportError(context, "Unable to read playlist: " + playlistToImport.toString(), e);
            return context.getString(R.string.unable_to_import_playlist);
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                Log.w(LOGTAG, "Unable to close playlist: " + playlistToImport.toString(), e);
                MusicUtils.reportError(context, "Unable to close playlist: " + playlistToImport.toString(), e);
            }
        }

        Uri createdPlaylist = MusicUtils.createPlaylist(context, name);
        long[] ids = new long[songIds.size()];
        for (int i = 0; i < ids.length; i++) ids[i] = songIds.get(i);
        MusicUtils.addToPlaylist(context, ids, createdPlaylist);

        if (ContentResolver.SCHEME_FILE.equals(playlistToImport.getScheme())) {
            boolean successful = new File(playlistToImport.getPath()).delete();
            if (!successful) {
                Log.w(LOGTAG, "Unable to delete playlist file: " + playlistToImport.toString());
                MusicUtils.reportError(context, "Unable to delete playlist file: " + playlistToImport.toString());
            }
        }

        return context.getString(R.string.playlist_imported);
    }

