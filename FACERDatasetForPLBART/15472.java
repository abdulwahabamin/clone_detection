    public void setupViewData(Cursor mCursor){

    	mLineOneText = mCursor.getString(mCursor.getColumnIndexOrThrow(ArtistColumns.ARTIST));
        int albums_plural = mCursor.getInt(mCursor.getColumnIndexOrThrow(ArtistColumns.NUMBER_OF_ALBUMS));
        boolean unknown = mLineOneText == null || mLineOneText.equals(MediaStore.UNKNOWN_STRING);
        mLineTwoText = MusicUtils.makeAlbumsLabel(mContext, albums_plural, 0, unknown);        
        mGridType = TYPE_ARTIST;        
        mImageData = new String[]{mLineOneText};
        mPlayingId = MusicUtils.getCurrentArtistId();
        mCurrentId = mCursor.getLong(mCursor.getColumnIndexOrThrow(BaseColumns._ID));
        
    }

