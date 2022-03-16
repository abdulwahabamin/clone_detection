    /**
     * {@inheritDoc}
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Change the preference manager
        getPreferenceManager().setSharedPreferencesName(Preferences.SETTINGS_FILENAME);
        getPreferenceManager().setSharedPreferencesMode(Context.MODE_PRIVATE);
        this.mLoaded = false;

        // Add the preferences
        addPreferencesFromResource(R.xml.preferences_search);

        // Highlight terms
        this.mHighlightTerms =
                (SwitchPreference)findPreference(
                        FileManagerSettings.SETTINGS_HIGHLIGHT_TERMS.getId());
        this.mHighlightTerms.setOnPreferenceChangeListener(this.mOnChangeListener);

        // Relevance widget
        this.mShowRelevanceWidget =
                (SwitchPreference)findPreference(
                        FileManagerSettings.SETTINGS_SHOW_RELEVANCE_WIDGET.getId());
        this.mShowRelevanceWidget.setOnPreferenceChangeListener(this.mOnChangeListener);

        // Sort search result mode
        this.mSortSearchResultMode =
                (ListPreference)findPreference(
                        FileManagerSettings.SETTINGS_SORT_SEARCH_RESULTS_MODE.getId());
        this.mSortSearchResultMode.setOnPreferenceChangeListener(this.mOnChangeListener);
        String defaultValue = ((ObjectStringIdentifier)FileManagerSettings.
                                SETTINGS_SORT_SEARCH_RESULTS_MODE.getDefaultValue()).getId();
        String value = Preferences.getSharedPreferences().getString(
                                FileManagerSettings.SETTINGS_SORT_SEARCH_RESULTS_MODE.getId(),
                                defaultValue);
        this.mOnChangeListener.onPreferenceChange(this.mSortSearchResultMode, value);

        // Saved search terms
        this.mSaveSearchTerms =
                (SwitchPreference)findPreference(
                        FileManagerSettings.SETTINGS_SAVE_SEARCH_TERMS.getId());
        this.mSaveSearchTerms.setOnPreferenceChangeListener(this.mOnChangeListener);

        // Remove search terms
        this.mRemoveSearchTerms = findPreference(REMOVE_SEARCH_TERMS_KEY);
        this.mRemoveSearchTerms.setOnPreferenceClickListener(this.mOnClickListener);

        // Loaded
        this.mLoaded = true;
    }

