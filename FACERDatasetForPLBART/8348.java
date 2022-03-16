    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle state) {
        if (DEBUG) {
            Log.d(TAG, "SearchActivity.onCreate"); //$NON-NLS-1$
        }

        // Check if app is running in chrooted mode
        this.mChRooted = FileManagerApplication.getAccessMode().compareTo(AccessMode.SAFE) == 0;

        final boolean displayThumbs = Preferences.getSharedPreferences().getBoolean(
                FileManagerSettings.SETTINGS_DISPLAY_THUMBS.getId(),
                ((Boolean)FileManagerSettings.SETTINGS_DISPLAY_THUMBS.getDefaultValue()).booleanValue());
        mIconHolder = new IconHolder(this, displayThumbs);
        mIconHolder.getDrawable("ic_fso_folder_drawable"); //$NON-NLS-1$
        mIconHolder.getDrawable("ic_fso_default_drawable"); //$NON-NLS-1$

        // Register the broadcast receiver
        IntentFilter filter = new IntentFilter();
        filter.addAction(FileManagerSettings.INTENT_SETTING_CHANGED);
        filter.addAction(FileManagerSettings.INTENT_THEME_CHANGED);
        registerReceiver(this.mNotificationReceiver, filter);

        // Set the theme before setContentView
        Theme theme = ThemeManager.getCurrentTheme(this);
        theme.setBaseTheme(this, false);

        //Set in transition
        overridePendingTransition(R.anim.translate_to_right_in, R.anim.hold_out);

        //Set the main layout of the activity
        setContentView(R.layout.search);

        //Restore state
        if (state != null) {
            restoreState(state);
        }

        //Initialize action bars and searc
        initTitleActionBar();
        initComponents();

        // Apply current theme
        applyTheme();

        if (this.mRestoreState != null) {
            //Restore activity from cached data
            loadFromCacheData();
        } else {
            //New query
            if (Intent.ACTION_SEARCH.equals(getIntent().getAction())) {
                initSearch();
            } else if (ACTION_RESTORE.equals(getIntent().getAction())) {
                restoreState(getIntent().getExtras());
                loadFromCacheData();
            }
        }

        mSearchFoundString = getString(R.string.search_found_items_in_directory);
        //$NON-NLS-1$
        mHighlightColor = theme.getColor(this, "search_highlight_color");

        //Save state
        super.onCreate(state);
    }

