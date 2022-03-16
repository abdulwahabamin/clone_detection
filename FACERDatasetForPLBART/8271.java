    /**
     * Method that applies the current theme to the activity
     * @hide
     */
    void applyTheme() {
        int orientation = getResources().getConfiguration().orientation;
        Theme theme = ThemeManager.getCurrentTheme(this);
        theme.setBaseThemeNoActionBar(this);
        applyTabTheme();

        // imitate a closed drawer while layout is rebuilt to avoid NullPointerException
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(Gravity.START);
        if (drawerOpen) {
            mDrawerLayout.closeDrawer(Gravity.START);
        }

        //- Layout
        View v = findViewById(R.id.navigation_layout);
        theme.setBackgroundDrawable(this, v, "background_drawable"); //$NON-NLS-1$

        //- ActionBar
        theme.setTitlebarDrawable(this, getActionBar(), "titlebar_drawable"); //$NON-NLS-1$

        // Hackery to theme search view
        mSearchView = (SearchView) findViewById(R.id.navigation_search_bar);
        int searchPlateId = mSearchView.getContext().getResources()
                .getIdentifier("android:id/search_plate", null, null);
        View searchPlate = mSearchView.findViewById(searchPlateId);
        if (searchPlate != null) {
            int searchTextId = searchPlate.getContext().getResources()
                    .getIdentifier("android:id/search_src_text", null, null);
            TextView searchText = (TextView) searchPlate.findViewById(searchTextId);
            if (searchText != null) {
                searchText.setTextColor(Color.WHITE);
                searchText.setHintTextColor(Color.WHITE);
            }

            int magId = getResources().getIdentifier("android:id/search_mag_icon", null, null);
            ImageView magImage = (ImageView) mSearchView.findViewById(magId);
            if (magImage != null) {
                magImage.setLayoutParams(new LinearLayout.LayoutParams(0, 0));
            }
        }

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        mSearchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        mSearchView.setIconifiedByDefault(false);

        mCustomTitleView = (NavigationCustomTitleView) findViewById(R.id.navigation_title_flipper);
        mCustomTitleView.setVisibility(View.VISIBLE);

        //- StatusBar
        v = findViewById(R.id.navigation_statusbar);
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            theme.setBackgroundDrawable(this, v, "titlebar_drawable"); //$NON-NLS-1$
        } else {
            theme.setBackgroundDrawable(this, v, "statusbar_drawable"); //$NON-NLS-1$
        }
        v = findViewById(R.id.ab_overflow);
        theme.setImageDrawable(this, (ImageView)v, "ab_overflow_drawable"); //$NON-NLS-1$
        v = findViewById(R.id.ab_actions);
        theme.setImageDrawable(this, (ImageView)v, "ab_actions_drawable"); //$NON-NLS-1$
        v = findViewById(R.id.ab_search);
        theme.setImageDrawable(this, (ImageView)v, "ab_search_drawable"); //$NON-NLS-1$

        //- Expanders
        v = findViewById(R.id.ab_configuration);
        theme.setImageDrawable(this, (ImageView)v, "expander_open_drawable"); //$NON-NLS-1$
        v = findViewById(R.id.ab_close);
        theme.setImageDrawable(this, (ImageView)v, "expander_close_drawable"); //$NON-NLS-1$
        v = findViewById(R.id.ab_sort_mode);
        theme.setImageDrawable(this, (ImageView)v, "ab_sort_mode_drawable"); //$NON-NLS-1$
        v = findViewById(R.id.ab_layout_mode);
        theme.setImageDrawable(this, (ImageView)v, "ab_layout_mode_drawable"); //$NON-NLS-1$
        v = findViewById(R.id.ab_view_options);
        theme.setImageDrawable(this, (ImageView)v, "ab_view_options_drawable"); //$NON-NLS-1$

        //- SelectionBar
        v = findViewById(R.id.navigation_selectionbar);
        theme.setBackgroundDrawable(this, v, "selectionbar_drawable"); //$NON-NLS-1$
        v = findViewById(R.id.ab_selection_done);
        theme.setImageDrawable(this, (ImageView)v, "ab_selection_done_drawable"); //$NON-NLS-1$
        v = findViewById(R.id.navigation_status_selection_label);
        theme.setTextColor(this, (TextView)v, "text_color"); //$NON-NLS-1$

        // - Navigation drawer
        v = findViewById(R.id.history_empty);
        theme.setTextColor(this, (TextView)v, "text_color"); //$NON-NLS-1$

        for (int i=0; i<mDrawerHistory.getChildCount(); i++) {
            View item = mDrawerHistory.getChildAt(i);

            v = item.findViewById(R.id.history_item_name);
            theme.setTextColor(this, (TextView)v, "text_color"); //$NON-NLS-1$
            v = item.findViewById(R.id.history_item_directory);
            theme.setTextColor(this, (TextView)v, "text_color"); //$NON-NLS-1$
        }

        //- NavigationView
        int cc = this.mNavigationViews.length;
        for (int i = 0; i < cc; i++) {
            getNavigationView(i).applyTheme();
        }

        // if drawer was open, imitate reopening
        if (drawerOpen) {
            mDrawerToggle.onDrawerOpened(mDrawer);
        }
    }

