        @Override
        public void changeCursor(Cursor cursor) {
            if (cursor != null && cursor.isClosed()) {
                return;
            }

            if (cursor != mActivity.mAlbumCursor) {
                mActivity.mAlbumCursor = cursor;
                getColumnIndices(cursor);
                super.changeCursor(cursor);
            }
        }

