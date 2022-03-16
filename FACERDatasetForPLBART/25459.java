	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PreferenceManager.setDefaultValues(this, R.xml.pretty_good_preferences, false);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = sharedPref.getString("pref_theme", getString(R.string.light));
        String size = sharedPref.getString("pref_text_size", getString(R.string.medium));
        Log.i(TAG, "got configured theme " + theme);
        Log.i(TAG, "got configured size " + size);
        currentTheme = theme;
        currentSize = size;
        // These settings were fixed in english for a while, so check for old style settings as well as language specific ones.
        if(theme.equalsIgnoreCase(getString(R.string.dark)) || theme.equalsIgnoreCase("dark")){
        	Log.i(TAG, "setting theme to " + theme);
        	if(size.equalsIgnoreCase(getString(R.string.small)) || size.equalsIgnoreCase("small")){
        		setTheme(R.style.PGMPDarkSmall);
        	} else if (size.equalsIgnoreCase(getString(R.string.medium)) || size.equalsIgnoreCase("medium")){
        		setTheme(R.style.PGMPDarkMedium);
        	} else {
        		setTheme(R.style.PGMPDarkLarge);
        	}
        } else if (theme.equalsIgnoreCase(getString(R.string.light)) || theme.equalsIgnoreCase("light")){
        	Log.i(TAG, "setting theme to " + theme);
        	if(size.equalsIgnoreCase(getString(R.string.small)) || size.equalsIgnoreCase("small")){
        		setTheme(R.style.PGMPLightSmall);
        	} else if (size.equalsIgnoreCase(getString(R.string.medium)) || size.equalsIgnoreCase("medium")){
        		setTheme(R.style.PGMPLightMedium);
        	} else {
        		setTheme(R.style.PGMPLightLarge);
        	}
        }
        setContentView(R.layout.activity_artist_list);
        
        ListView lv = (ListView) findViewById(R.id.artistListView);

        // React to user clicks on item
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

             public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                     long id) {
            	 // TODO just use the position instead
            	 TextView clickedView = (TextView) view.findViewById(R.id.PGMPListItemText);
            	 // Apparently sometimes clickedview returns the listview, other times it returns the text view
            	 if(clickedView == null){
            		 if(view instanceof TextView){
            			 clickedView = (TextView)view;
            		 } else{
            			 Log.w(TAG, "Got null clicked view");
            			 return;
            		 }
            	 }
            	 if(!clickedView.getText().equals(PICK_DIR_TEXT)){
	            	 Intent intent = new Intent(ArtistList.this, AlbumList.class);
	            	 intent.putExtra(ARTIST_NAME, clickedView.getText());
					 if(clickedView.getText().equals("All")){
						 intent.putExtra(ARTIST_ABS_PATH_NAME, "All");
						 startActivity(intent);
					 } else {
						 intent.putExtra(ARTIST_ABS_PATH_NAME, baseDir + File.separator + clickedView.getText());
						 startActivity(intent);
					 }
            	 } else {
            		 Intent intent = new Intent(ArtistList.this, SettingsActivity.class);
            		 startActivity(intent);
            	 }
             }
        });
    }

