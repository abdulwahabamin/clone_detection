	@Override
	public void onCreate() {
		super.onCreate();
		
    	mApp = (Common) this.getApplicationContext();
		
		//Register a broadcast listener to listen for track updates.
        receiver = new BroadcastReceiver() {
        	
            @Override
            public void onReceive(Context context, Intent intent) {
                updateExtensionData();
                
            }
            
        };
        
    	LocalBroadcastManager.getInstance(this)
		 					 .registerReceiver((receiver), 
		 							 			new IntentFilter("com.aniruddhc.acemusic.player.NEW_SONG_UPDATE_UI"));
		
	}

