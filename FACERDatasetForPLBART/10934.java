    /**
     * Method that initializes the layout and components of the activity.
     */
    private void initLayout() {
        this.mEditor = (EditText)findViewById(R.id.editor);
        this.mEditor.setText(null);
        this.mEditor.addTextChangedListener(this);
        this.mEditor.setEnabled(false);
        this.mWordWrapView = (ViewGroup)findViewById(R.id.editor_word_wrap_view);
        this.mNoWordWrapView = (ViewGroup)findViewById(R.id.editor_no_word_wrap_view);
        this.mWordWrapView.setVisibility(View.VISIBLE);
        this.mNoWordWrapView.setVisibility(View.GONE);

        this.mBinaryEditor = (ListView)findViewById(R.id.editor_binary);

        this.mNoSuggestions = false;
        this.mWordWrap = true;
        this.mSyntaxHighlight = true;

        // Load the no suggestions setting
        boolean noSuggestionsSetting = Preferences.getSharedPreferences().getBoolean(
                FileManagerSettings.SETTINGS_EDITOR_NO_SUGGESTIONS.getId(),
                ((Boolean)FileManagerSettings.SETTINGS_EDITOR_NO_SUGGESTIONS.
                        getDefaultValue()).booleanValue());
        if (noSuggestionsSetting != this.mNoSuggestions) {
            toggleNoSuggestions();
        }

        // Load the word wrap setting
        boolean wordWrapSetting = Preferences.getSharedPreferences().getBoolean(
                FileManagerSettings.SETTINGS_EDITOR_WORD_WRAP.getId(),
                ((Boolean)FileManagerSettings.SETTINGS_EDITOR_WORD_WRAP.
                        getDefaultValue()).booleanValue());
        if (wordWrapSetting != this.mWordWrap) {
            toggleWordWrap();
        }

        // Load the syntax highlight setting
        boolean syntaxHighlighSetting = Preferences.getSharedPreferences().getBoolean(
                FileManagerSettings.SETTINGS_EDITOR_SYNTAX_HIGHLIGHT.getId(),
                ((Boolean)FileManagerSettings.SETTINGS_EDITOR_SYNTAX_HIGHLIGHT.
                        getDefaultValue()).booleanValue());
        if (syntaxHighlighSetting != this.mSyntaxHighlight) {
            toggleSyntaxHighlight();
        }

        this.mProgress = findViewById(R.id.editor_progress);
        this.mProgressBar = (ProgressBar)findViewById(R.id.editor_progress_bar);
        this.mProgressBarMsg = (TextView)findViewById(R.id.editor_progress_msg);
    }

