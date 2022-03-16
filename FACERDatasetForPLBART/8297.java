    /**
     * Method that applies the current theme to the activity
     * @hide
     */
    void applyTheme() {
        Theme theme = ThemeManager.getCurrentTheme(this);
        theme.setBaseTheme(this, true);

        // View
        theme.setBackgroundDrawable(this, this.mRootView, "background_drawable"); //$NON-NLS-1$
        this.mNavigationView.applyTheme();
    }

