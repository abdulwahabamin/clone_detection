	public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
	    if (//When the user chooses to show/hide hidden files, update the list
    		//to correspond with the user's choice
    		PreferenceActivity.PREFS_DISPLAYHIDDENFILES.equals(key)
    		//When the user changes the sortBy settings, update the list
    		|| PreferenceActivity.PREFS_SORTBY.equals(key)
    		|| PreferenceActivity.PREFS_ASCENDING.equals(key)){
	    	
        	refreshList();
	    }
	}

