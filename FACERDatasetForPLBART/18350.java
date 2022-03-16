    /**
     * Sets the entire activity-wide theme.
     */
    private void setTheme() {
        if (mApp.getCurrentTheme()==Common.DARK_THEME) {
            setTheme(R.style.AppThemeNoActionBar);
        } else {
            setTheme(R.style.AppThemeLightNoActionBar);
        }

    }

