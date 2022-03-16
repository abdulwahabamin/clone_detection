	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		mContext = this;
		sharedPreferences = getSharedPreferences("com.aniruddhc.acemusic.player", Context.MODE_PRIVATE);
		
    	//Get the screen's parameters.
	    DisplayMetrics displayMetrics = new DisplayMetrics();
	    this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
	    int screenWidth = displayMetrics.widthPixels;
		
    	//Set the UI theme.
    	if (sharedPreferences.getString(Common.CURRENT_THEME, "LIGHT_CARDS_THEME").equals("DARK_THEME") ||
    		sharedPreferences.getString(Common.CURRENT_THEME, "LIGHT_CARDS_THEME").equals("DARK_CARDS_THEME")) {
    		setTheme(R.style.AppTheme);
    	} else {
    		setTheme(R.style.AppThemeLight);
    	}

    	super.onCreate(savedInstanceState);
    	
    	if (getOrientation().equals("PORTRAIT")) {

    		//Finish this activity and relaunch the activity that called this one.
    		Intent intent = new Intent(this, (Class<?>) getIntent().getSerializableExtra("CALLING_CLASS"));
    		intent.putExtras(getIntent());
    		intent.putExtra("NEW_PLAYLIST", false);
    		intent.putExtra("CALLED_FROM_FOOTER", true);
    		intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
    		finish();
    		startActivity(intent);
    		
    		return;
    		
    	} else {
    		
    		setContentView(R.layout.activity_now_playing_queue);
    		
        	final Fragment nowPlayingQueueFragment = new NowPlayingQueueFragment();
    	    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    	    transaction.add(R.id.now_playing_queue_container, nowPlayingQueueFragment, "nowPlayingQueueFragment");
    	    transaction.commit();
    		
    	    SpannableString s = new SpannableString(getResources().getString(R.string.current_queue));
    	    s.setSpan(new TypefaceSpan(this, "RobotoCondensed-Light"), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

    	    // Update the action bar title with the TypefaceSpan instance.
    	    ActionBar actionBar = getActionBar();
    	    actionBar.setTitle(s);
    	    actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.holo_gray_selector));
    	    
    	}
    	
	}

