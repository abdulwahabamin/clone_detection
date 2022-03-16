    public NowPlayingQueueListViewAdapter(Context context, ArrayList<Integer> playbackIndecesList) {
    	
    	super(context, R.id.playlists_flipped_song, playbackIndecesList);
    	
    	mContext = context;
    	mApp = (Common) mContext.getApplicationContext();
    	sharedPreferences = mContext.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
    	mPlaybackIndecesList = playbackIndecesList;
    	mCurrentTheme = sharedPreferences.getString(Common.CURRENT_THEME, "LIGHT_CARDS_THEME");
    	
    }

