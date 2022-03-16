	@Override
	protected void onResume() {
		super.onResume();
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

		String accentColor = sharedPref.getString("accent_color", getResources().getStringArray(R.array.accentcoloroptions)[0]);
		String customAccentColor = sharedPref.getString("custom_accent_color", "");
		String colorOptions[] = getResources().getStringArray(R.array.accentcoloroptions);
		// TODO I'm sure there's a better way to do this, I'm just not sure what it is...
		for(int i = 0;i<colorOptions.length;i++){
			if(accentColor.equals(colorOptions[i])){
				switch(i){
				case 0: 
					setAccentColors(getResources().getColor(R.color.agategrey));
					break;
				case 1: 
					setAccentColors(getResources().getColor(R.color.blackgreen));
					break;
				case 2: 
					setAccentColors(getResources().getColor(R.color.brilliantblue));
					break;
				case 3: 
					setAccentColors(getResources().getColor(R.color.brilliantorange));
					break;
				case 4: 
					setAccentColors(getResources().getColor(R.color.emeraldgreen));
					break;
				case 5: 
					setAccentColors(getResources().getColor(R.color.ivory));
					break;
				case 6: 
					setAccentColors(getResources().getColor(R.color.skyblue));
					break;
				case 7: 
					setAccentColors(getResources().getColor(R.color.trafficgreen));
					break;
				case 8: 
					setAccentColors(getResources().getColor(R.color.waterblue));
					break;
				case 9: 
					try{
						Log.i(TAG, "custom color: " + customAccentColor);
						if(!customAccentColor.startsWith("#")){
							customAccentColor = "#" + customAccentColor;
						}
						if(customAccentColor.toLowerCase(Locale.getDefault()).startsWith("0x")){
							customAccentColor = customAccentColor.substring(2);
						}
						int custom = Color.parseColor(customAccentColor.trim());
						setAccentColors(custom);
					} catch (Exception e){
						Log.w(TAG, "Unable to parse custom color", e);
					}
					break;
				}
			}
		}
		
		String theme = sharedPref.getString("pref_theme", getString(R.string.light));
		String size = sharedPref.getString("pref_text_size", getString(R.string.medium));
		boolean fullScreen = sharedPref.getBoolean("pref_full_screen_now_playing", false);
		Log.i(TAG, "got configured theme " + theme);
		Log.i(TAG, "Got configured size " + size);
		if(currentTheme == null){
			currentTheme = theme;
		} 

		if(currentSize == null){
			currentSize = size;
		}
		if(!currentTheme.equals(theme) || !currentSize.equals(size) || currentFullScreen != fullScreen){
			finish();
			startActivity(getIntent());
		}
	}

