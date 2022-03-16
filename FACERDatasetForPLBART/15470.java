    public void setupViewData(Cursor mCursor){
        
    	mLineOneText = mCursor.getString(mCursor.getColumnIndexOrThrow(AlbumColumns.ALBUM));
        mLineTwoText = mCursor.getString(mCursor.getColumnIndexOrThrow(AlbumColumns.ARTIST));     
        mGridType = TYPE_ALBUM;        
        mImageData =  new String[]{ mCursor.getString(mCursor.getColumnIndexOrThrow(BaseColumns._ID)) , mLineTwoText, mLineOneText };
        mPlayingId = MusicUtils.getCurrentAlbumId();
        mCurrentId = mCursor.getLong(mCursor.getColumnIndexOrThrow(BaseColumns._ID));
        
    }

