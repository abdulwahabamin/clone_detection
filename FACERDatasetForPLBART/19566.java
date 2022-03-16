	@Override
	public void onCreate() {
		
		//Initialize SharedPreferences.
        sharedPreferences = this.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
        mContext = this;
		super.onCreate();
		
	}

