    public static void playAll(Context context, long[] list) {
        if (list.length == 0 || sService == null) {
            Log.d(LOGTAG, "attempt to play empty song list");
            // Don't try to play empty playlists. Nothing good will come of it.
            String message = context.getString(R.string.emptyplaylist);
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            return;
        }
        sService.load(list, 0);
    }

