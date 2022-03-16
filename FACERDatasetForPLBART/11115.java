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
        addPreferencesFromResource(R.xml.preferences_storage);

        // Reset password
        mResetPassword = findPreference(KEY_RESET_PASSWORD);
        mResetPassword.setOnPreferenceClickListener(mOnClickListener);

        // Delete storage
        mDeleteStorage = findPreference(KEY_DELETE_STORAGE);
        mDeleteStorage.setOnPreferenceClickListener(mOnClickListener);

        // Delayed sync
        this.mDelayedSync =
                (SwitchPreference)findPreference(
                        FileManagerSettings.SETTINGS_SECURE_STORAGE_DELAYED_SYNC.getId());
        this.mDelayedSync.setOnPreferenceChangeListener(this.mOnChangeListener);

        // Update the preferences
        updatePreferences();
    }

