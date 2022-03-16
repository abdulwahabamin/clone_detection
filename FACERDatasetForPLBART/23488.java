        /**
         * This method is called whenever we receive a new cursor due to
         * an async query, and must take care of plugging the new one in
         * to the adapter.
         */
        @Override
        public void changeCursor(Cursor cursor) {
            super.changeCursor(cursor);
            if (DBG) Log.v(TAG, "Setting cursor to: " + cursor
                    + " from: " + MusicPicker.this.mCursor);
            
            MusicPicker.this.mCursor = cursor;
            
            if (cursor != null) {
                // Retrieve indices of the various columns we are interested in.
                mIdIdx = cursor.getColumnIndex(MediaStore.Audio.Media._ID);
                mTitleIdx = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
                mArtistIdx = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
                mAlbumIdx = cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
                mDurationIdx = cursor.getColumnIndex(MediaStore.Audio.Media.DURATION);

                // If the sort mode has changed, or we haven't yet created an
                // indexer one, then create a new one that is indexing the
                // appropriate column based on the sort mode.
                if (mIndexerSortMode != mSortMode || mIndexer == null) {
                    mIndexerSortMode = mSortMode;
                    int idx = mTitleIdx;
                    switch (mIndexerSortMode) {
                        case ARTIST_MENU:
                            idx = mArtistIdx;
                            break;
                        case ALBUM_MENU:
                            idx = mAlbumIdx;
                            break;
                    }
                    mIndexer = new MusicAlphabetIndexer(cursor, idx,
                            getResources().getString(
                                    com.android.internal.R.string.fast_scroll_alphabet));
                    
                // If we have a valid indexer, but the cursor has changed since
                // its last use, then point it to the current cursor.
                } else {
                    mIndexer.setCursor(cursor);
                }
            }
            
            // Ensure that the list is shown (and initial progress indicator
            // hidden) in case this is the first cursor we have gotten.
            makeListShown();
        }

