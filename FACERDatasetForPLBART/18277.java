    public AsyncRemovePlaylistEntryTask(Context context, String entryId) {
    	mContext = context;
    	sharedPreferences = mContext.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
    	mEntryId = entryId;
    	
    }

