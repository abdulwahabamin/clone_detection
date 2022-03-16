    /**
     * Reload the queue after we remove a track
     */
    private void reloadQueueCursor() {
        String[] projection = new String[] {
                BaseColumns._ID, MediaColumns.TITLE, AudioColumns.ALBUM, AudioColumns.ARTIST,
        };
        StringBuilder selection = new StringBuilder();
        Uri uri = Audio.Media.EXTERNAL_CONTENT_URI;
        String sortOrder = Audio.Media.DEFAULT_SORT_ORDER;
        uri = Audio.Media.EXTERNAL_CONTENT_URI;
        long[] mNowPlaying = MusicUtils.getQueue();
        if (mNowPlaying.length == 0)
            return;
        selection = new StringBuilder();
        selection.append(BaseColumns._ID + " IN (");
        if (mNowPlaying == null || mNowPlaying.length <= 0)
            return;
        for (long queue_id : mNowPlaying) {
            selection.append(queue_id + ",");
        }
        selection.deleteCharAt(selection.length() - 1);
        selection.append(")");

        mCursor = MusicUtils.query(getActivity(), uri, projection, selection.toString(), null,
                sortOrder);
        mQuickQueueAdapter.changeCursor(mCursor);
    }

