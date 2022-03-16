    public static int addToPlaylist(Context context, long[] ids, Uri uri) {
        int size = ids.length;
        ContentResolver resolver = context.getContentResolver();
        // need to determine the number of items currently in the playlist,
        // so the play_order field can be maintained.
        Cursor cur = resolver.query(uri, new String[] { "count(*)" }, null, null, null);
        if (cur != null) {
            cur.moveToFirst();
            int base = cur.getInt(0);
            cur.close();
            int numInserted = 0;
            for (int i = 0; i < size; i += 1000) {
                makeInsertItems(ids, i, 1000, base);
                numInserted += resolver.bulkInsert(uri, sContentValuesCache);
            }
            return numInserted;
        } else {
            Log.w(LOGTAG, "Unable to lookup playlist: " + uri.toString());
            return -1;
        }
    }

