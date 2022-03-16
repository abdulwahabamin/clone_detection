	@SuppressWarnings("unchecked")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		//Initialize Context and SharedPreferences.
		mContext = this;
        mApp = (Common) mContext.getApplicationContext();
		
		//Retrieve the name/icon of the library from the arguments.
		libraryName = getIntent().getExtras().getString("LIBRARY_NAME");
		libraryIconName = getIntent().getExtras().getString("LIBRARY_ICON");
		
		if (getIntent().getExtras().getSerializable("SONG_IDS_HASH_SET")!=null) {
			songDBIdsList = (HashSet<String>) getIntent().getExtras().getSerializable("SONG_IDS_HASH_SET");
		}

    	//Set the UI theme.
    	if (mApp.getCurrentTheme()==Common.DARK_THEME) {
    		setTheme(R.style.AppTheme);
    	} else {
    		setTheme(R.style.AppThemeLight);
    	}
		super.onCreate(savedInstanceState);
		
		//Initialize the database helper.
		dbHelper = new DBAccessHelper(mContext.getApplicationContext());

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
		
		//Attach tabs to the ActionBar.
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		//Add the artists tab.
		String artistsLabel = getResources().getString(R.string.artists);
		Tab tab = actionBar.newTab();
		tab.setText(artistsLabel);
		TabListener<ArtistsPickerFragment> artistsTabListener = new TabListener<ArtistsPickerFragment>(this, 
																					   				   artistsLabel, 
																					   				   ArtistsPickerFragment.class);
		
		tab.setTabListener(artistsTabListener);
		actionBar.addTab(tab);

		//Add the albums tab.
		String albumsLabel = getResources().getString(R.string.albums);
		tab = actionBar.newTab();
		tab.setText(albumsLabel);
		TabListener<AlbumsPickerFragment> albumsTabListener = new TabListener<AlbumsPickerFragment>(this,
																					  				albumsLabel, 
																					  				AlbumsPickerFragment.class);
		
		tab.setTabListener(albumsTabListener);
		actionBar.addTab(tab);
		
		//Add the songs tab.
		String songsLabel = getResources().getString(R.string.songs);
		tab = actionBar.newTab();
		tab.setText(songsLabel);
		TabListener<SongsPickerFragment> songsTabListener = new TabListener<SongsPickerFragment>(this,
																								 songsLabel, 
																								 SongsPickerFragment.class);
		
		tab.setTabListener(songsTabListener);
		actionBar.addTab(tab);
		
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
		
	}

