    /**
     * Method that applies the current theme to the tab host
     */
    private void applyTabTheme() {
        // Apply the theme
        Theme theme = ThemeManager.getCurrentTheme(this);

        View v = findViewById(R.id.drawer);
        theme.setBackgroundDrawable(this, v, "background_drawable"); //$NON-NLS-1$

        v = findViewById(R.id.drawer_bookmarks_tab);
        theme.setTextColor(this, (TextView)v, "text_color"); //$NON-NLS-1$
        v = findViewById(R.id.drawer_history_tab);
        theme.setTextColor(this, (TextView)v, "text_color"); //$NON-NLS-1$

        v = findViewById(R.id.ab_settings);
        theme.setImageDrawable(this, (ButtonItem) v, "ab_settings_drawable"); //$NON-NLS-1$
        v = findViewById(R.id.ab_clear_history);
        theme.setImageDrawable(this, (ButtonItem) v, "ab_delete_drawable"); //$NON-NLS-1$
    }

