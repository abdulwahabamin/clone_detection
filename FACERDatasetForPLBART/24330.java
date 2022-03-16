    protected void getIndexer(Cursor cursor) {
        if (cursor != null) {
            if (mIndexer != null) {
                mIndexer.setCursor(cursor);
            } else {
                mIndexer = new MusicAlphabetIndexer(cursor, mActivity.getNameColumnIndex(cursor),
                        mResources.getString(R.string.fast_scroll_alphabet));
            }
        }
    }

