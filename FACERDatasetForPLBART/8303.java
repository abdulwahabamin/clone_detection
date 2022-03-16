    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Change the preference manager
        getPreferenceManager().setSharedPreferencesName(Preferences.SETTINGS_FILENAME);
        getPreferenceManager().setSharedPreferencesMode(Context.MODE_PRIVATE);

        // Add the preferences
        addPreferencesFromResource(R.xml.preferences_editor_color_scheme);

        // Color scheme (need to resolver color scheme prior to use theme default)
        loadDefaultColorScheme(false);

        // Reset to default theme color scheme
        this.mResetColorScheme = findPreference(KEY_RESET_COLOR_SCHEME);

        // Now the listeners
        this.mResetColorScheme.setOnPreferenceClickListener(this.mOnClickListener);

        // Loaded
        this.mLoaded = true;
    }

