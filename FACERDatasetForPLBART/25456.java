    @Override
	protected void onResume() {
		super.onResume();
        SharedPreferences prefs = getSharedPreferences("PrettyGoodMusicPlayer", MODE_PRIVATE);
        prefs.edit();
        File bestGuessMusicDir = Utils.getBestGuessMusicDirectory();
        String prefDir = prefs.getString("ARTIST_DIRECTORY", bestGuessMusicDir.getAbsolutePath());
        ListView lv = (ListView) findViewById(R.id.artistListView);
        if(!prefDir.equals(baseDir)){
        	baseDir = prefDir;
        	populateArtists(baseDir);
            
            simpleAdpt = new SimpleAdapter(this, artists,  R.layout.pgmp_list_item, new String[] {"artist"}, new int[] {R.id.PGMPListItemText});
            lv.setAdapter(simpleAdpt);
        }
        
        int top = prefs.getInt("ARTIST_LIST_TOP", Integer.MIN_VALUE);
        int index = prefs.getInt("ARTIST_LIST_INDEX", Integer.MIN_VALUE);
        if(top > Integer.MIN_VALUE && index > Integer.MIN_VALUE){
        	Log.i(TAG, "Setting position from saved preferences");
        	lv.setSelectionFromTop(index, top);
        } else {
        	Log.i(TAG, "No saved position found");
        }

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = sharedPref.getString("pref_theme", getString(R.string.light));
        String size = sharedPref.getString("pref_text_size", getString(R.string.medium));
        Log.i(TAG, "got configured theme " + theme);
        Log.i(TAG, "Got configured size " + size);
        if(currentTheme == null){
        	currentTheme = theme;
        } 
        
        if(currentSize == null){
        	currentSize = size;
        }
        if(!currentTheme.equals(theme) || !currentSize.equals(size)) {
			finish();
			startActivity(getIntent());
		}
	}

