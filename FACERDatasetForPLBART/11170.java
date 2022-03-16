    /**
     * Method that applies the current theme to the activity
     * @hide
     */
    void applyTheme() {
        Theme theme = ThemeManager.getCurrentTheme(this);
        theme.setBaseTheme(this, false);

        //- ActionBar
        View v = getActionBar().getCustomView().findViewById(R.id.customtitle_title);
        theme.setTextColor(this, (TextView)v, "action_bar_text_color"); //$NON-NLS-1$
        v = findViewById(R.id.ab_button1);
        theme.setImageDrawable(this, (ImageView)v, "ic_config_drawable"); //$NON-NLS-1$
        // ContentView
        theme.setBackgroundDrawable(
                this, getWindow().getDecorView(), "background_drawable"); //$NON-NLS-1$
        //- StatusBar
        v = findViewById(R.id.search_status);
        theme.setBackgroundDrawable(this, v, "statusbar_drawable"); //$NON-NLS-1$
        v = findViewById(R.id.search_status_found_items);
        theme.setTextColor(this, (TextView)v, "action_bar_text_color"); //$NON-NLS-1$
        v = findViewById(R.id.search_status_query_terms);
        theme.setTextColor(this, (TextView)v, "action_bar_text_color"); //$NON-NLS-1$

        //ListView
        if (this.mSearchListView.getAdapter() != null) {
            ((SearchResultAdapter)this.mSearchListView.getAdapter()).notifyDataSetChanged();
        }
        this.mSearchListView.setDivider(
                theme.getDrawable(this, "horizontal_divider_drawable")); //$NON-NLS-1$
        this.mSearchListView.invalidate();
    }

