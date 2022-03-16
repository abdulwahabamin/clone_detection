    public String getAlbumName() {
        synchronized (this) {
            if (mCursor == null) {
                return getString(R.string.unknown);
            }
            return mCursor.getString(mCursor.getColumnIndexOrThrow(AudioColumns.ALBUM));
        }
    }

