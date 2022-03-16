	/**
	 * Text color.
	 */
	public static int getTextColor(Context context) {
		
		mApp = (Common) context.getApplicationContext();
		int color;
		
		//The gray theme needs its own colors regardless of the application theme.
		if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, "BLUE").equals("GRAY")) {
			
			color = Color.parseColor("#FFFFFF");
			
		} else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, "BLUE").equals("WHITE")) {
			
			color = Color.parseColor("#0F0F0F");
			
		} else {
			
			if (mApp.getCurrentTheme()==Common.DARK_THEME) {
				color = Color.parseColor("#FFFFFF");
			} else {
				color = Color.parseColor("#5F5F5F");
			}
			
		}
		
		return color;
		
	}

