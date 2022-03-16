	/**
	 * Small text color.
	 */
	public static int getSmallTextColor(Context context) {
		
		mApp = (Common) context.getApplicationContext();
		int color;
			
		if (mApp.getCurrentTheme()==Common.DARK_THEME) {
			color = Color.parseColor("#999999");
		} else {
			color = Color.parseColor("#7F7F7F");
		}

		return color;
		
	}

