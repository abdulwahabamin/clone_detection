    /**
     * Sets the activity's theme based on user preferences.
     */
    private void setTheme() {
        if (mApp.getCurrentTheme()==Common.DARK_THEME) {
            this.setTheme(R.style.AppThemeNoActionBar);
        } else {
            this.setTheme(R.style.AppThemeLightNoActionBar);
        }
        
    }

