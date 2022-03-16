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
        addPreferencesFromResource(R.xml.preferences_editor);

        // No suggestions
        this.mNoSuggestions =
                (SwitchPreference)findPreference(
                        FileManagerSettings.SETTINGS_EDITOR_NO_SUGGESTIONS.getId());
        this.mNoSuggestions.setOnPreferenceChangeListener(this.mOnChangeListener);

        // WordWrap
        this.mWordWrap =
                (SwitchPreference)findPreference(
                        FileManagerSettings.SETTINGS_EDITOR_WORD_WRAP.getId());
        this.mWordWrap.setOnPreferenceChangeListener(this.mOnChangeListener);

        // Hexdump
        this.mHexdump =
                (SwitchPreference)findPreference(
                        FileManagerSettings.SETTINGS_EDITOR_HEXDUMP.getId());
        this.mHexdump.setOnPreferenceChangeListener(this.mOnChangeListener);

        // Syntax highlight
        this.mSyntaxHighlight =
                (SwitchPreference)findPreference(
                        FileManagerSettings.SETTINGS_EDITOR_SYNTAX_HIGHLIGHT.getId());
        this.mSyntaxHighlight.setOnPreferenceChangeListener(this.mOnChangeListener);

        // Loaded
        this.mLoaded = true;
    }

