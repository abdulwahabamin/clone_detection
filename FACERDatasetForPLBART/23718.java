        @Override
        public void changeCursor(Cursor cursor) {
            if ( cursor != null && cursor.isClosed() )
                 return;
            if (cursor != mActivity.mTrackCursor) {
                mActivity.mTrackCursor = cursor;
                super.changeCursor(cursor);
                getColumnIndices(cursor);
            }
        }

