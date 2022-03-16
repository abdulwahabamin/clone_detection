    /**
     * Method that applies the current theme to the activity
     * @hide
     */
    void applyTheme() {
        Theme theme = ThemeManager.getCurrentTheme(this);
        theme.setBaseTheme(this, false);

        View v = getActionBar().getCustomView().findViewById(R.id.customtitle_title);
        theme.setTextColor(this, (TextView)v, "action_bar_text_color"); //$NON-NLS-1$

        // -View
        theme.setBackgroundDrawable(
                this,
                this.getWindow().getDecorView(),
                "background_drawable"); //$NON-NLS-1$
    }

