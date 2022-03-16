    public AsyncAddToQueueTask(Context context,
    						   Fragment fragment,
    						   String enqueueType,
    						   String artistName,
    						   String albumName,
    						   String songTitle,
    						   String genreName,
    						   String playlistId, 
    						   String playlistName,
    						   String albumArtistName) {
    	
    	mContext = context;
    	mApp = (Common) mContext;
    	
    	mArtistName = artistName;
    	mAlbumName = albumName;
    	mSongTitle = songTitle;
    	mGenreName = genreName;
    	mPlaylistId = playlistId;
    	mPlaylistName = playlistName;
    	mAlbumArtistName = albumArtistName;
    	
    	mFragment = fragment;
    	mEnqueueType = enqueueType;
    	
    	if (mApp.getService().getPlaybackIndecesList()!=null) {
    		originalPlaybackIndecesSize = mApp.getService().getPlaybackIndecesList().size();
    	}
    	
    }

