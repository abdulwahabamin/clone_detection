    public void setupViewData( Cursor mCursor ){
    	mLineOneText = mCursor.getString(mCursor.getColumnIndexOrThrow(AlbumColumns.ALBUM));    	
        int songs_plural = mCursor.getInt(mCursor.getColumnIndexOrThrow(AlbumColumns.NUMBER_OF_SONGS));
    	mLineTwoText =MusicUtils.makeAlbumsLabel(mContext, 0, songs_plural, true );    	
        String artistName = mCursor.getString(mCursor.getColumnIndexOrThrow(AlbumColumns.ARTIST));        
        String albumId = mCursor.getString(mCursor.getColumnIndexOrThrow(BaseColumns._ID));
        mImageData = new String[]{ albumId , artistName, mLineOneText };        
        mPlayingId = MusicUtils.getCurrentAlbumId();
        mCurrentId = Long.parseLong(albumId);        
        mListType = TYPE_ALBUM;   	
    }

