    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        if (mTrackCursor.getCount() == 0) {
            return;
        }
        MusicUtils.playAll(this, mTrackCursor, position);
    }

