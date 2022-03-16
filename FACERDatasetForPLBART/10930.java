    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle state) {
        if (DEBUG) {
            Log.d(TAG, "EditorActivity.onCreate"); //$NON-NLS-1$
        }

        this.mHandler = new Handler();

        // Load typeface for hex editor
        mHexTypeface = Typeface.createFromAsset(getAssets(), "fonts/Courier-Prime.ttf");

        // Save hexdump user preference
        mHexDump = Preferences.getSharedPreferences().getBoolean(
                FileManagerSettings.SETTINGS_EDITOR_HEXDUMP.getId(),
                ((Boolean)FileManagerSettings.SETTINGS_EDITOR_HEXDUMP.
                        getDefaultValue()).booleanValue());

        // Register the broadcast receiver
        IntentFilter filter = new IntentFilter();
        filter.addAction(FileManagerSettings.INTENT_THEME_CHANGED);
        filter.addAction(FileManagerSettings.INTENT_SETTING_CHANGED);
        registerReceiver(this.mNotificationReceiver, filter);

        // Generate a random separator
        this.mHexLineSeparator = UUID.randomUUID().toString() + UUID.randomUUID().toString();

        // Set the theme before setContentView
        Theme theme = ThemeManager.getCurrentTheme(this);
        theme.setBaseTheme(this, false);

        //Set the main layout of the activity
        setContentView(R.layout.editor);

        // Get the limit vars
        this.mBufferSize = getResources().getInteger(R.integer.buffer_size);
        long availMem = AndroidHelper.getAvailableMemory(this);
        this.mMaxFileSize = Math.min(availMem,
                getResources().getInteger(R.integer.editor_max_file_size));

        //Initialize
        initTitleActionBar();
        initLayout();

        // Apply the theme
        applyTheme();

        // Initialize the console
        initializeConsole();

        // Read the file
        readFile();

        //Save state
        super.onCreate(state);
    }

