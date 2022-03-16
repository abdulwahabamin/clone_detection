    private void removeItemFromPlaylist(int which) {
        adapter.getCursor().moveToPosition(which);
        long itemId = adapter.getCursor().getLong(adapter.getCursor().getColumnIndexOrThrow(MediaStore.Audio.Playlists.Members._ID));
        Log.d(LOGTAG, "Removing item " + itemId + " from playlist " + uri.toString());
        Uri uri = MediaStore.Audio.Playlists.Members.getContentUri("external", playlist);
        int rowCount = getActivity().getContentResolver().delete(ContentUris.withAppendedId(uri, itemId), null, null);
        if (rowCount < 1) {
            Log.i(LOGTAG, "Unable to remove item " + itemId + " from playlist " + uri.toString());
        }
    }

