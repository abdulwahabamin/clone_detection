	/**
	 * Returns the resource ID for the music player controls background
	 * in NowPlayingActivity.java.
	 */
	public static int getNowPlayingControlsBackground(Context context) {
		
		int resourceID = 0;
		mApp = (Common) context.getApplicationContext();
		
		if (mApp.getCurrentTheme()==Common.DARK_THEME) {
			resourceID = context.getResources().getIdentifier("now_playing_controls_background", "drawable", context.getPackageName());
		} else {
			resourceID = context.getResources().getIdentifier("now_playing_controls_background_light", "drawable", context.getPackageName());
		}
		
		return resourceID;
		
	}

