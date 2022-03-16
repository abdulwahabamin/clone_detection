	@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		setTheme(R.style.AppThemeNoActionBar);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launcher);
		
		mContext = this;
		mActivity = this;
		mApp = (Common) mContext.getApplicationContext();
		mHandler = new Handler();
		
		//Increment the start count. This value will be used to determine when the library should be rescanned.
    	int startCount = mApp.getSharedPreferences().getInt("START_COUNT", 1);
    	mApp.getSharedPreferences().edit().putInt("START_COUNT", startCount+1).commit();
		
		//Save the dimensions of the layout for later use on KitKat devices.
		final RelativeLayout launcherRootView = (RelativeLayout) findViewById(R.id.launcher_root_view);
		launcherRootView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() {
				
				try {
					
					int screenDimens[] = new int[2];
					int screenHeight = 0;
					int screenWidth = 0;
		            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
		            	//API levels 14, 15 and 16.
		            	screenDimens = getTrueDeviceResolution();
		            	screenWidth = screenDimens[0];
		            	screenHeight = screenDimens[1];
		            	
		            } else {
		            	//API levels 17+.
		            	Display display = getWindowManager().getDefaultDisplay();
		            	DisplayMetrics metrics = new DisplayMetrics();
		            	display.getRealMetrics(metrics);
		            	screenHeight = metrics.heightPixels;
		            	screenWidth = metrics.widthPixels;
		            	
		            }
					
					int layoutHeight = launcherRootView.getHeight();
					int layoutWidth = launcherRootView.getWidth();
					
					int extraHeight = screenHeight - layoutHeight;
					int extraWidth = screenWidth = layoutWidth;
					
					mApp.getSharedPreferences().edit().putInt("KITKAT_HEIGHT", layoutHeight).commit();
					mApp.getSharedPreferences().edit().putInt("KITKAT_WIDTH", layoutWidth).commit();
					mApp.getSharedPreferences().edit().putInt("KITKAT_HEIGHT_LAND", layoutWidth - extraHeight).commit();
					mApp.getSharedPreferences().edit().putInt("KITKAT_WIDTH_LAND", screenHeight).commit();

				} catch (Exception e) {
					e.printStackTrace();
				}
				
		    }
			
		});
		
		//Build the music library based on the user's scan frequency preferences.
        int scanFrequency = mApp.getSharedPreferences().getInt("SCAN_FREQUENCY", 5);
        int updatedStartCount = mApp.getSharedPreferences().getInt("START_COUNT", 1);
		
		//Launch the appropriate activity based on the "FIRST RUN" flag.
		if (mApp.getSharedPreferences().getBoolean(Common.FIRST_RUN, true)==true) {
			
        	//Create the default Playlists directory if it doesn't exist.
        	File playlistsDirectory = new File(Environment.getExternalStorageDirectory() + "/Playlists/");
        	if (!playlistsDirectory.exists() || !playlistsDirectory.isDirectory()) {
        		playlistsDirectory.mkdir();
        	}
			
			//Disable equalizer for HTC devices by default.
			if (mApp.getSharedPreferences().getBoolean(Common.FIRST_RUN, true)==true &&
				Build.PRODUCT.contains("HTC")) {
				mApp.getSharedPreferences().edit().putBoolean("EQUALIZER_ENABLED", false).commit();
			}
			
        	//Send out a test broadcast to initialize the homescreen/lockscreen widgets.
        	sendBroadcast(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME));
			
			Intent intent = new Intent(this, WelcomeActivity.class);
			startActivity(intent);
			overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
			
		} else if (mApp.isBuildingLibrary()) {
			buildingLibraryMainText = (TextView) findViewById(R.id.building_music_library_text);
	        buildingLibraryInfoText = (TextView) findViewById(R.id.building_music_library_info);
	        buildingLibraryLayout = (RelativeLayout) findViewById(R.id.building_music_library_layout);
	        
	        buildingLibraryInfoText.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
	        buildingLibraryInfoText.setPaintFlags(buildingLibraryInfoText.getPaintFlags() |
	        								  	  Paint.ANTI_ALIAS_FLAG |
	        								  	  Paint.SUBPIXEL_TEXT_FLAG);
	        
	        buildingLibraryMainText.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
	        buildingLibraryMainText.setPaintFlags(buildingLibraryMainText.getPaintFlags() |
	        								  	  Paint.ANTI_ALIAS_FLAG |
	        								  	  Paint.SUBPIXEL_TEXT_FLAG);
	        
	        buildingLibraryMainText.setText(R.string.jams_is_building_library);
	        buildingLibraryLayout.setVisibility(View.VISIBLE);
	        
	        //Initialize the runnable that will fire once the scan process is complete.
			mHandler.post(scanFinishedCheckerRunnable);
		
		} else if (mApp.getSharedPreferences().getBoolean("RESCAN_ALBUM_ART", false)==true) {

			buildingLibraryMainText = (TextView) findViewById(R.id.building_music_library_text);
	        buildingLibraryInfoText = (TextView) findViewById(R.id.building_music_library_info);
	        buildingLibraryLayout = (RelativeLayout) findViewById(R.id.building_music_library_layout);
	        
	        buildingLibraryInfoText.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
	        buildingLibraryInfoText.setPaintFlags(buildingLibraryInfoText.getPaintFlags() |
	        								  	  Paint.ANTI_ALIAS_FLAG |
	        								  	  Paint.SUBPIXEL_TEXT_FLAG);
	        
	        buildingLibraryMainText.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
	        buildingLibraryMainText.setPaintFlags(buildingLibraryMainText.getPaintFlags() |
	        								  	  Paint.ANTI_ALIAS_FLAG |
	        								  	  Paint.SUBPIXEL_TEXT_FLAG);
	        
	        buildingLibraryMainText.setText(R.string.jams_is_caching_artwork);
	        initScanProcess(0);
	        
		} else if ((mApp.getSharedPreferences().getBoolean("REBUILD_LIBRARY", false)==true) || 
				   (scanFrequency==0 && mApp.isScanFinished()==false) || 
				   (scanFrequency==1 && mApp.isScanFinished()==false && updatedStartCount%3==0) || 
				   (scanFrequency==2 && mApp.isScanFinished()==false && updatedStartCount%5==0) || 
				   (scanFrequency==3 && mApp.isScanFinished()==false && updatedStartCount%10==0) || 
				   (scanFrequency==4 && mApp.isScanFinished()==false && updatedStartCount%20==0)) {
			
			buildingLibraryMainText = (TextView) findViewById(R.id.building_music_library_text);
	        buildingLibraryInfoText = (TextView) findViewById(R.id.building_music_library_info);
	        buildingLibraryLayout = (RelativeLayout) findViewById(R.id.building_music_library_layout);
	        
	        buildingLibraryInfoText.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
	        buildingLibraryInfoText.setPaintFlags(buildingLibraryInfoText.getPaintFlags() |
	        								  	  Paint.ANTI_ALIAS_FLAG |
	        								  	  Paint.SUBPIXEL_TEXT_FLAG);
	        
	        buildingLibraryMainText.setTypeface(TypefaceHelper.getTypeface(mContext, "RobotoCondensed-Light"));
	        buildingLibraryMainText.setPaintFlags(buildingLibraryMainText.getPaintFlags() |
	        								  	  Paint.ANTI_ALIAS_FLAG |
	        								  	  Paint.SUBPIXEL_TEXT_FLAG);
	        
	        initScanProcess(1);
	        
		} else {
			
			//Check if this activity was called from Settings.
			if (getIntent().hasExtra("UPGRADE")) {
				if (getIntent().getExtras().getBoolean("UPGRADE")==true) {
					mExplicitShowTrialFragment = true;
				} else {
					mExplicitShowTrialFragment = false;
				}
				
			}

			//initInAppBilling();
            launchMainActivity();
		}

		//Fire away a report to Google Analytics.
		try {
			if (mApp.isGoogleAnalyticsEnabled()==true) {
				EasyTracker easyTracker = EasyTracker.getInstance(this);
		    	easyTracker.send(MapBuilder.createEvent("ACE startup.",     // Event category (required)
			                   						  	"User started ACE.",  // Event action (required)
			                   						  	"User started ACE.",   // Event label
			                   						  	null)            // Event value
						   .build());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

