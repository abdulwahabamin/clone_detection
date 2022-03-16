    public static void addToPlaylist(Context context, long [] ids, long playlistid) {
        if (ids == null) {
            // this shouldn't happen (the menuitems shouldn't be visible
            // unless the selected item represents something playable
            Log.e(LOGTAG, "ListSelection null");
        } else {
            Uri uri = MediaStore.Audio.Playlists.Members.getContentUri("external", playlistid);
            int numInserted = addToPlaylist(context, ids, uri);
            Toast.makeText(context, context.getResources().getQuantityString(
                    R.plurals.NNNtrackstoplaylist, numInserted, numInserted), Toast.LENGTH_SHORT).show();
        }
    }

