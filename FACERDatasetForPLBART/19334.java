    public NowPlayingQueueListAdapter(Context context, ArrayList<Integer> playbackIndecesList) {
    	
    	super(context, -1, playbackIndecesList);
    	
    	mContext = context;
    	mApp = (Common) mContext;
    	mPlaybackIndecesList = playbackIndecesList;
    	
    }

