        public void drop(int from, int to) {
            if (mTrackCursor instanceof NowPlayingCursor) {
                // update the currently playing list
                NowPlayingCursor c = (NowPlayingCursor) mTrackCursor;
                c.moveItem(from, to);
                ((TrackListAdapter)getListAdapter()).notifyDataSetChanged();
                getListView().invalidateViews();
                mDeletedOneRow = true;
            } else {
                // update a saved playlist
                Uri baseUri = MediaStore.Audio.Playlists.Members.getContentUri("external",
                        Long.valueOf(mPlaylist));
                ContentValues values = new ContentValues();
                String where = MediaStore.Audio.Playlists.Members._ID + "=?";
                String [] wherearg = new String[1];
                ContentResolver res = getContentResolver();

                int colidx = mTrackCursor.getColumnIndexOrThrow(
                        MediaStore.Audio.Playlists.Members.PLAY_ORDER);
                if (from < to) {
                    // move the item to somewhere later in the list
                    mTrackCursor.moveToPosition(to);
                    int toidx = mTrackCursor.getInt(colidx);
                    mTrackCursor.moveToPosition(from);
                    values.put(MediaStore.Audio.Playlists.Members.PLAY_ORDER, toidx);
                    wherearg[0] = mTrackCursor.getString(0);
                    res.update(baseUri, values, where, wherearg);
                    for (int i = from + 1; i <= to; i++) {
                        mTrackCursor.moveToPosition(i);
                        values.put(MediaStore.Audio.Playlists.Members.PLAY_ORDER, i - 1);
                        wherearg[0] = mTrackCursor.getString(0);
                        res.update(baseUri, values, where, wherearg);
                    }
                } else if (from > to) {
                    // move the item to somewhere earlier in the list
                    mTrackCursor.moveToPosition(to);
                    int toidx = mTrackCursor.getInt(colidx);
                    mTrackCursor.moveToPosition(from);
                    values.put(MediaStore.Audio.Playlists.Members.PLAY_ORDER, toidx);
                    wherearg[0] = mTrackCursor.getString(0);
                    res.update(baseUri, values, where, wherearg);
                    for (int i = from - 1; i >= to; i--) {
                        mTrackCursor.moveToPosition(i);
                        values.put(MediaStore.Audio.Playlists.Members.PLAY_ORDER, i + 1);
                        wherearg[0] = mTrackCursor.getString(0);
                        res.update(baseUri, values, where, wherearg);
                    }
                }
            }
        }

