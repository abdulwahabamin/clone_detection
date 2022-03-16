	/**
	 * Sets the entire activity-wide theme.
	 */
	private void setTheme() {
    	//Set the UI theme.
    	if (mApp.getCurrentTheme()==Common.DARK_THEME) {
    		setTheme(R.style.AppTheme);
    	} else {
    		setTheme(R.style.AppThemeLight);
    	}
    	
	}

