	@Override
	public void onCreate() {
		super.onCreate();

		//Application context.
		mContext = getApplicationContext();

		//SharedPreferences.
		mSharedPreferences = this.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);

		//Init the database.
		mDBAccessHelper = new DBAccessHelper(mContext);

    	//Playback kickstarter.
    	mPlaybackKickstarter = new PlaybackKickstarter(this.getApplicationContext());

        //Picasso.
        mPicasso = new Picasso.Builder(mContext).build();

    	//ImageLoader.
    	mImageLoader = ImageLoader.getInstance();
    	mImageLoaderConfiguration = new ImageLoaderConfiguration.Builder(getApplicationContext())
    														   .memoryCache(new WeakMemoryCache())
    														   .memoryCacheSizePercentage(13)
    														   .imageDownloader(new ByteArrayUniversalImageLoader(mContext))
    														   .build();
    	mImageLoader.init(mImageLoaderConfiguration);

        //Init DisplayImageOptions.
        initDisplayImageOptions();

		//Log the user into Google Play Music only if the account is currently set up and active.
		if (mSharedPreferences.getBoolean("GOOGLE_PLAY_MUSIC_ENABLED", false)==true) {

			//Create a temp WebView to retrieve the user agent string.
			String userAgentString = "";
			if (mSharedPreferences.getBoolean("GOT_USER_AGENT", false)==false) {
				WebView webView = new WebView(getApplicationContext());
				webView.setVisibility(View.GONE);
				webView.loadUrl("http://www.google.com");
				userAgentString = webView.getSettings().getUserAgentString();
				mSharedPreferences.edit().putBoolean("GOT_USER_AGENT", true).commit();
				mSharedPreferences.edit().putString("USER_AGENT", userAgentString).commit();
				webView = null;
			}

			setGMusicClientCalls(GMusicClientCalls.getInstance(getApplicationContext()));
			GMusicClientCalls.setWebClientUserAgent(userAgentString);
			String accountName = mSharedPreferences.getString("GOOGLE_PLAY_MUSIC_ACCOUNT", "");

			//Authenticate with Google.
			AsyncGoogleMusicAuthenticationTask task = new AsyncGoogleMusicAuthenticationTask(mContext, false, accountName);
			task.execute();

		}

	}

