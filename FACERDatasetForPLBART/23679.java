        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(MediaPlaybackService.META_CHANGED)) {
                getListView().invalidateViews();
            } else if (intent.getAction().equals(MediaPlaybackService.QUEUE_CHANGED)) {
                if (mDeletedOneRow) {
                    // This is the notification for a single row that was
                    // deleted previously, which is already reflected in
                    // the UI.
                    mDeletedOneRow = false;
                    return;
                }
                Cursor c = new NowPlayingCursor(MusicUtils.sService, mCursorCols);
                if (c.getCount() == 0) {
                    finish();
                    return;
                }
                if (mAdapter != null) {
                    mAdapter.changeCursor(c);
                } else {
                    c.close();
                }
            }
        }

