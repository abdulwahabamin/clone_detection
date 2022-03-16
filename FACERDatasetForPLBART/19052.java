	/**
	 * Returns an array of color values for the QuickScroll view.
	 */
	public static int[] getQuickScrollColors(Context context) {

		int[] colors = new int[3];
        colors[0] = 0xFFB0120A;
        colors[1] = 0x99B0120A;
        colors[2] = Color.WHITE;
		
		mApp = (Common) context.getApplicationContext();
		if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(BLUE)) {
			colors[0] = 0xFF0099CC;
			colors[1] = 0x990099CC;
			colors[2] = Color.WHITE;
			
		} else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(RED)) {
			colors[0] = 0xFFB0120A;
			colors[1] = 0x99B0120A;
			colors[2] = Color.WHITE;
			
		} else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(GREEN)) {
			colors[0] = 0xFF0E9E8B;
			colors[1] = 0x990E9E8B;
			colors[2] = Color.WHITE;
			
		} else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(ORANGE)) {
			colors[0] = 0xFFEF6C00;
			colors[1] = 0x99EF6C00;
			colors[2] = Color.WHITE;
			
		} else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(PURPLE)) {
			colors[0] = 0xFF6A1B9A;
			colors[1] = 0x996A1B9A;
			colors[2] = Color.WHITE;
			
		} else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(MAGENTA)) {
			colors[0] = 0xFF3B5998;
			colors[1] = 0x993B5998;
			colors[2] = Color.WHITE;
			
		}
		
		return colors;
	}

