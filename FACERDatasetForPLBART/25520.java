    @Override
	protected void onResume() {
		super.onResume();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = sharedPref.getString("pref_theme", getString(R.string.light));
        String size = sharedPref.getString("pref_text_size", getString(R.string.medium));
        boolean audiobookModePref = sharedPref.getBoolean("pref_audiobook_mode", false);
        Log.i(TAG, "got configured theme " + theme);
        Log.i(TAG, "Got configured size " + size);
        if(currentTheme == null){
        	currentTheme = theme;
        } 
        
        if(currentSize == null){
        	currentSize = size;
        }
        
        boolean resetResume = false;
        if(audiobookMode != audiobookModePref){
        	resetResume = true;
        }
        SharedPreferences prefs = getSharedPreferences("PrettyGoodMusicPlayer", MODE_PRIVATE);
        String newResume = prefs.getString(albumDir.getAbsolutePath(), null);
        if(resume != null && newResume != null && !newResume.equals(resume)){
        	resetResume = true;
        }else if(resume == null && newResume != null){
        	resetResume = true;
        }
        
        if(!currentTheme.equals(theme) || !currentSize.equals(size) || resetResume){
        	// Calling finish and startActivity will re-launch this activity, applying the new settings
        	finish();
        	startActivity(getIntent());
        }
	}

