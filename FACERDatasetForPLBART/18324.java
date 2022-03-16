	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		//Initialize Context and SharedPreferences.
		mContext = this;
		mActivity = this;
		mApp = (Common) this.getApplicationContext();
		sharedPreferences = mContext.getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
		
    	//Set the UI theme.
    	if (mApp.getCurrentTheme()==Common.DARK_THEME) {
    		setTheme(R.style.AppTheme);
    	} else {
    		setTheme(R.style.AppThemeLight);
    	}
		super.onCreate(savedInstanceState);
		
	    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
	    	getWindow().setBackgroundDrawable(UIElementsHelper.getGeneralActionBarBackground(mContext));
	    	int topPadding = Common.getStatusBarHeight(mContext);
	    	View activityView = (View) findViewById(android.R.id.content);
	    	
	    	//Calculate ActionBar height
            TypedValue tv = new TypedValue();
            int actionBarHeight = 0;
            if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
                actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
            }
            
            if (activityView!=null) {
            	activityView.setPadding(0, topPadding + actionBarHeight, 0, 0);
            }
            
	    }

		//Retrieve the actionbar.
		actionBar = getActionBar();
		
		//Create a set of options to optimize the bitmap memory usage.
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        
        //Display Image Options.
        int defaultArt = UIElementsHelper.getIcon(mContext, "default_album_art_padded");
        displayImageOptions = new DisplayImageOptions.Builder()
        						  .showImageForEmptyUri(R.drawable.default_album_art)
        						  .showImageOnFail(R.drawable.default_album_art)
        						  .showStubImage(R.drawable.transparent_drawable)
        						  .cacheInMemory(false)
        						  .cacheOnDisc(true)
        						  .decodingOptions(options)
        						  .imageScaleType(ImageScaleType.EXACTLY)
        						  .bitmapConfig(Bitmap.Config.RGB_565)
        						  .displayer(new FadeInBitmapDisplayer(400))
        						  .delayBeforeLoading(100)
        						  .build();
		
		//Retrieve a list of blacklisted songs.
		AsyncGetAllSongIdsBlacklistStatusTask task = new AsyncGetAllSongIdsBlacklistStatusTask();
		task.execute();
			
	}

