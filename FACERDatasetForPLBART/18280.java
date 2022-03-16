    public AsyncReorderPlaylistEntriesTask(Context context, 
    								   	   String playlistId,
    								   	   String playlistName,
    								   	   ArrayList<String> songId,
    								   	   ArrayList<String> songEntryId,
    								   	   String afterEntryId,
    								   	   String beforeEntryId,
    								   	   ArrayList<String> entryIds,
    								   	   ArrayList<String> songIds) {
    	
    	mContext = context;
    	sharedPreferences = mContext.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
    	
    	mPlaylistId = playlistId;
    	mSongId = songId;
    	mSongEntryId = songEntryId;
    	mAfterEntryId = afterEntryId;
    	mBeforeEntryId = afterEntryId;
    	mPlaylistName = playlistName;
    	mEntryIds = entryIds;
    	mSongIds = songIds;
    	
    }

