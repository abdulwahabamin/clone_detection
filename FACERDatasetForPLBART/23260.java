        @Override
        public void changeCursor(Cursor cursor) {
             if (cursor != null && cursor.isClosed()) {
                return;
             }

             synchronized (mActivity) {
                if ( mCursorInactive ) {
                    return;
                }

                if (cursor != mActivity.mArtistCursor) {
                    mActivity.mArtistCursor = cursor;
                    getColumnIndices(cursor);
                    super.changeCursor(cursor);
                }
            }
        }

