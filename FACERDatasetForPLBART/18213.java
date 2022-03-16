    private void createMediaStorePlaylist(String playlistName) {
    	ContentValues mInserts = new ContentValues();
        mInserts.put(MediaStore.Audio.Playlists.NAME, playlistName);
        mInserts.put(MediaStore.Audio.Playlists.DATE_ADDED, System.currentTimeMillis());
        mInserts.put(MediaStore.Audio.Playlists.DATE_MODIFIED, System.currentTimeMillis());
        Uri mUri = mContext.getContentResolver().insert(MediaStore.Audio.Playlists.EXTERNAL_CONTENT_URI, mInserts);
        if (mUri != null) {
            Cursor c = mContext.getContentResolver().query(mUri, PROJECTION_PLAYLIST, null, null, null);
            if (c != null) {
                /* Save the newly created ID so it can be selected. Names are allowed to be duplicated,
                 * but IDs can never be. */
            	c.moveToFirst();
                mPlaylistId = "" + c.getLong(c.getColumnIndex(MediaStore.Audio.Playlists._ID));
                c.close();
            }

        }
        
    }

