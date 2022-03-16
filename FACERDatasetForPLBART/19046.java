	/**
	 * Background gradient in the flipped fragments' listviews.
	 * 
	 * NOTE: The dark theme now uses the default background. 
	 * 		 Only the light theme will use a custom background.
	 */
	public static Drawable getBackgroundGradientDrawable(Context context) {
		
		Drawable backgroundDrawable;
		mApp = (Common) context.getApplicationContext();
		
		if (mApp.getCurrentTheme()==Common.DARK_THEME) {
			backgroundDrawable = context.getResources().getDrawable(R.drawable.dark_gray_gradient);
		} else {
			backgroundDrawable = context.getResources().getDrawable(R.drawable.holo_white_selector);
		}
		
		return backgroundDrawable;
	}

