    private void export(long playlistId, int prefix, File file) {
        Writer writer = null;
        Cursor cursor = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            cursor = context.getContentResolver().query(
                    MusicContract.Playlist.getMembersUri(playlistId),
                    new String[]{MediaStore.Audio.AudioColumns.DATA},
                    null,
                    null,
                    null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    if (isCancelled()) break;
                    String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns.DATA));
                    writer.write(path, prefix, path.length() - prefix);
                    writer.write('\n');
                }
            } else {
                Log.w(LOGTAG, "Unable to get song list");
            }
        } catch (IOException e) {
            Log.w(LOGTAG, "Unable to export playlist", e);
        } finally {
            try {
                if (cursor != null) cursor.close();
            } catch (Exception e) {
                Log.w(LOGTAG, "Unable to close cursor", e);
            }
            try {
                if (writer != null) writer.close();
            } catch (IOException e) {
                Log.w(LOGTAG, "Unable to close exported playlist", e);
            }
        }
    }

