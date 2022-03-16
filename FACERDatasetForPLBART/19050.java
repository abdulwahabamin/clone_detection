	/**
	 * Returns the ActionBar color based on the selected color theme (not used for the player).
	 */
	public static Drawable getGeneralActionBarBackground(Context context) {
		
		mApp = (Common) context.getApplicationContext();
		
		Drawable drawable = new ColorDrawable(0xFFB0120A);
		if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(BLUE)) {
			drawable = new ColorDrawable(0xFF03A9F4);
			
		} else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(RED)) {
			drawable = new ColorDrawable(0xFFB0120A);
			
		} else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(GREEN)) {
			drawable = new ColorDrawable(0xFF00BFA5);
			
		} else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(ORANGE)) {
			drawable = new ColorDrawable(0xFFEF6C00);
			
		} else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(PURPLE)) {
			drawable = new ColorDrawable(0xFFFF5722);
			
		} else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(MAGENTA)) {
			drawable = new ColorDrawable(0xFFFFC107);
			
		}
        else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(GRAY)) {
            drawable = new ColorDrawable(0xFF9e9e9e);

        }
        else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(BLACK)) {
            drawable = new ColorDrawable(0xFF424242);

        }
        else if (mApp.getSharedPreferences().getString(NOW_PLAYING_COLOR, BLUE).equals(WHITE)) {
            drawable = new ColorDrawable(0xFFd8d8d8);

        }
		
		return drawable;
		
	}

