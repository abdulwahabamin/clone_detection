    private void makeNowPlayingCursor() {
        mCurrentPlaylistCursor = null;
        try {
            mNowPlaying = mService.getQueue();
        } catch (RemoteException ex) {
            mNowPlaying = new long[0];
        }
        mSize = mNowPlaying.length;
        if (mSize == 0) {
            return;
        }

        StringBuilder where = new StringBuilder();
        where.append(BaseColumns._ID + " IN (");
        for (int i = 0; i < mSize; i++) {
            where.append(mNowPlaying[i]);
            if (i < mSize - 1) {
                where.append(",");
            }
        }
        where.append(")");

        mCurrentPlaylistCursor = MusicUtils.query(context, Audio.Media.EXTERNAL_CONTENT_URI,
                mProjection, where.toString(), null, BaseColumns._ID);

        if (mCurrentPlaylistCursor == null) {
            mSize = 0;
            return;
        }

        int size = mCurrentPlaylistCursor.getCount();
        mCursorIdxs = new long[size];
        mCurrentPlaylistCursor.moveToFirst();
        int colidx = mCurrentPlaylistCursor.getColumnIndexOrThrow(BaseColumns._ID);
        for (int i = 0; i < size; i++) {
            mCursorIdxs[i] = mCurrentPlaylistCursor.getLong(colidx);
            mCurrentPlaylistCursor.moveToNext();
        }
        mCurrentPlaylistCursor.moveToFirst();
        try {
            int removed = 0;
            for (int i = mNowPlaying.length - 1; i >= 0; i--) {
                long trackid = mNowPlaying[i];
                int crsridx = Arrays.binarySearch(mCursorIdxs, trackid);
                if (crsridx < 0) {
                    removed += mService.removeTrack(trackid);
                }
            }
            if (removed > 0) {
                mNowPlaying = mService.getQueue();
                mSize = mNowPlaying.length;
                if (mSize == 0) {
                    mCursorIdxs = null;
                    return;
                }
            }
        } catch (RemoteException ex) {
            mNowPlaying = new long[0];
        }
    }

