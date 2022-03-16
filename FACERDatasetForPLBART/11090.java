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
        addPreferencesFromResource(R.xml.preferences_general);

        // Case sensitive sort
        this.mCaseSensitiveSort =
                (SwitchPreference)findPreference(
                        FileManagerSettings.SETTINGS_CASE_SENSITIVE_SORT.getId());
        this.mCaseSensitiveSort.setOnPreferenceChangeListener(this.mOnChangeListener);

        // Filetime format mode
        this.mFiletimeFormatMode =
                (ListPreference)findPreference(
                        FileManagerSettings.SETTINGS_FILETIME_FORMAT_MODE.getId());
        String defaultValue = ((ObjectStringIdentifier)FileManagerSettings.
                SETTINGS_FILETIME_FORMAT_MODE.getDefaultValue()).getId();
        String value = Preferences.getSharedPreferences().getString(
                            FileManagerSettings.SETTINGS_FILETIME_FORMAT_MODE.getId(),
                            defaultValue);
        this.mOnChangeListener.onPreferenceChange(this.mFiletimeFormatMode, value);
        this.mFiletimeFormatMode.setOnPreferenceChangeListener(this.mOnChangeListener);

        // Disk usage warning level
        this.mFreeDiskSpaceWarningLevel =
                (ListPreference)findPreference(
                        FileManagerSettings.SETTINGS_DISK_USAGE_WARNING_LEVEL.getId());
        defaultValue = ((String)FileManagerSettings.
                            SETTINGS_DISK_USAGE_WARNING_LEVEL.getDefaultValue());
        value = Preferences.getSharedPreferences().getString(
                            FileManagerSettings.SETTINGS_DISK_USAGE_WARNING_LEVEL.getId(),
                            defaultValue);
        this.mOnChangeListener.onPreferenceChange(this.mFreeDiskSpaceWarningLevel, value);
        this.mFreeDiskSpaceWarningLevel.setOnPreferenceChangeListener(this.mOnChangeListener);

        // Compute folder statistics
        this.mComputeFolderStatistics =
                (SwitchPreference)findPreference(
                        FileManagerSettings.SETTINGS_COMPUTE_FOLDER_STATISTICS.getId());
        this.mComputeFolderStatistics.setOnPreferenceChangeListener(this.mOnChangeListener);

        // Display thumbs
        this.mDisplayThumbs =
                (SwitchPreference)findPreference(
                        FileManagerSettings.SETTINGS_DISPLAY_THUMBS.getId());
        this.mDisplayThumbs.setOnPreferenceChangeListener(this.mOnChangeListener);

        // Use flinger
        this.mUseFlinger =
                (SwitchPreference)findPreference(
                        FileManagerSettings.SETTINGS_USE_FLINGER.getId());
        this.mUseFlinger.setOnPreferenceChangeListener(this.mOnChangeListener);

        // Access mode
        this.mAccessMode =
                (ListPreference)findPreference(
                        FileManagerSettings.SETTINGS_ACCESS_MODE.getId());
        this.mAccessMode.setOnPreferenceChangeListener(this.mOnChangeListener);
        defaultValue = ((ObjectStringIdentifier)FileManagerSettings.
                            SETTINGS_ACCESS_MODE.getDefaultValue()).getId();
        value = Preferences.getSharedPreferences().getString(
                            FileManagerSettings.SETTINGS_ACCESS_MODE.getId(),
                            defaultValue);
        this.mOnChangeListener.onPreferenceChange(this.mAccessMode, value);
        updateAccessModeStatus();

        // Capture Debug traces
        this.mRestrictSecondaryUsersAccess =
                (SwitchPreference)findPreference(
                        FileManagerSettings.SETTINGS_RESTRICT_SECONDARY_USERS_ACCESS.getId());
        if (!AndroidHelper.hasSupportForMultipleUsers(getActivity()) ||
                AndroidHelper.isSecondaryUser(getActivity())) {
            // Remove if device doesn't support multiple users accounts or the current user
            // is a secondary user
            PreferenceCategory category = (PreferenceCategory) findPreference(
                    "general_advanced_settings");
            category.removePreference(this.mRestrictSecondaryUsersAccess);
        } else {
            this.mRestrictSecondaryUsersAccess.setChecked(
                    FileManagerApplication.isRestrictSecondaryUsersAccess(getActivity()));
            this.mRestrictSecondaryUsersAccess.setOnPreferenceChangeListener(this.mOnChangeListener);
        }

        // Capture Debug traces
        this.mDebugTraces =
                (SwitchPreference)findPreference(
                        FileManagerSettings.SETTINGS_SHOW_TRACES.getId());
        this.mDebugTraces.setOnPreferenceChangeListener(this.mOnChangeListener);

        // Loaded
        this.mLoaded = true;
    }

