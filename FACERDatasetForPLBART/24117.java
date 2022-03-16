    private void init() {
        if (mCurrentPlaylistCursor != null) {
            mCurrentPlaylistCursor.close();
            mCurrentPlaylistCursor = null;
        }
        playQueue = service.getQueue();
        mSize = playQueue.length;
        if (mSize == 0) {
            return;
        }

        mCurrentPlaylistCursor = contentResolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                COLUMNS, buildPlayQueueWhereClause(playQueue), null, MediaStore.Audio.AudioColumns._ID);

        if (mCurrentPlaylistCursor == null) {
            mSize = 0;
            return;
        }

        int size = mCurrentPlaylistCursor.getCount();
        mCursorIdxs = new long[size];
        mCurrentPlaylistCursor.moveToFirst();
        int colidx = mCurrentPlaylistCursor.getColumnIndexOrThrow(MediaStore.Audio.AudioColumns._ID);
        for (int i = 0; i < size; i++) {
            mCursorIdxs[i] = mCurrentPlaylistCursor.getLong(colidx);
            mCurrentPlaylistCursor.moveToNext();
        }
        mCurrentPlaylistCursor.moveToFirst();
        mCurPos = -1;

        // At this point we can verify the 'now playing' list we got
        // earlier to make sure that all the items in there still exist
        // in the database, and remove those that aren't. This way we
        // don't get any blank items in the list.
        int removed = 0;
        for (int i = playQueue.length - 1; i >= 0; i--) {
            long trackid = playQueue[i];
            int crsridx = Arrays.binarySearch(mCursorIdxs, trackid);
            if (crsridx < 0) {
                Log.i(TAG, "item no longer exists in db: " + trackid);
                removed += service.removeTrack(trackid);
            }
        }
        if (removed > 0) {
            playQueue = service.getQueue();
            mSize = playQueue.length;
            if (mSize == 0) {
                mCursorIdxs = null;
            }
        }
    }

