	/**
	 * Returns the background color for the Now Playing elements in NowPlayingQueueFragment. 
	 */
	public static int getNowPlayingQueueBackground(Context context) {
		int hexColor;
		mApp = (Common) context.getApplicationContext();
		
		if (mApp.getCurrentTheme()==Common.DARK_THEME) {
			hexColor = 0xFF3A3A3A;
		} else {
			hexColor = 0xFFDCDCDC;
		}
		
		return hexColor;
	}

