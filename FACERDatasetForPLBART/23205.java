    private void setTitle() {
        CharSequence fancyName = "";
        //Added check on the cursor object. It shouldn't point to the position before
        //first or after last row to prevent "CursorIndexOutOfBounds" exception.
        if (mAlbumCursor != null && mAlbumCursor.getCount() > 0 &&
            !mAlbumCursor.isBeforeFirst() && !mAlbumCursor.isAfterLast()) {
            mAlbumCursor.moveToFirst();
            fancyName = mAlbumCursor.getString(3);
            if (fancyName == null || fancyName.equals(MediaFile.UNKNOWN_STRING))
                fancyName = getText(R.string.unknown_artist_name);
        }

        if (mArtistId != null && fancyName != null)
            setTitle(fancyName);
        else
            setTitle(R.string.albums_title);
    }

