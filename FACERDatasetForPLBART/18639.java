    /**
     * Sets the activity theme based on the user preference.
     */
    private void setTheme() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (mApp.getCurrentTheme()==Common.DARK_THEME) {
                setTheme(R.style.AppThemeNoTranslucentNav);
            } else {
                setTheme(R.style.AppThemeNoTranslucentNavLight);
            }

        } else {
            if (mApp.getCurrentTheme()==Common.DARK_THEME) {
                setTheme(R.style.AppTheme);
            } else {
                setTheme(R.style.AppThemeLight);
            }

        }

    }

