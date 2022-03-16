	/**
	 *  Text color. Plain and simple.
	 */
	public static int getThemeBasedTextColor(Context context) {
		mApp = (Common) context.getApplicationContext();
		int color;
		
		if (mApp.getCurrentTheme()==Common.DARK_THEME) {
			color = Color.parseColor("#DEDEDE");
		} else {
			color = Color.parseColor("#404040");
		}
		
		return color;
		
	}

