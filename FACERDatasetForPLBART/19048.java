	/**
	 * Returns the resource ID for the music player info (song, artist, album)
	 * background in NowPlayingActivity.java.
	 */
	public static int getNowPlayingInfoBackground(Context context) {
		
		int resourceID = 0;
		mApp = (Common) context.getApplicationContext();
		
		if (mApp.getCurrentTheme()==Common.DARK_THEME) {
			return R.drawable.solid_black_drawable;
		} else {
			resourceID = context.getResources().getIdentifier("now_playing_title_background_light", "drawable", context.getPackageName());
		}
		
		return resourceID;
		
	}

