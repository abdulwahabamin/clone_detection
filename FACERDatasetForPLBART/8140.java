        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if (intent.getAction().compareTo(FileManagerSettings.INTENT_THEME_CHANGED) == 0) {
                    applyTheme();
                    return;
                }
                if (intent.getAction().compareTo(FileManagerSettings.INTENT_SETTING_CHANGED) == 0) {
                    // The settings has changed
                    String key = intent.getStringExtra(FileManagerSettings.EXTRA_SETTING_CHANGED_KEY);
                    if (key != null) {
                        final EditorActivity activity = EditorActivity.this;

                        // No suggestions
                        if (key.compareTo(FileManagerSettings.SETTINGS_EDITOR_NO_SUGGESTIONS.getId()) == 0) {
                            // Ignore in binary files
                            if (activity.mBinary) return;

                            // Do we have a different setting?
                            boolean noSuggestionsSetting =
                                    Preferences.getSharedPreferences().getBoolean(
                                        FileManagerSettings.SETTINGS_EDITOR_NO_SUGGESTIONS.getId(),
                                        ((Boolean)FileManagerSettings.SETTINGS_EDITOR_NO_SUGGESTIONS.
                                                getDefaultValue()).booleanValue());
                            if (noSuggestionsSetting != activity.mNoSuggestions) {
                                activity.mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        toggleNoSuggestions();
                                    }
                                });
                            }

                        // Word wrap
                        } else if (key.compareTo(FileManagerSettings.SETTINGS_EDITOR_WORD_WRAP.getId()) == 0) {
                            // Ignore in binary files
                            if (activity.mBinary) return;

                            // Do we have a different setting?
                            boolean wordWrapSetting = Preferences.getSharedPreferences().getBoolean(
                                    FileManagerSettings.SETTINGS_EDITOR_WORD_WRAP.getId(),
                                    ((Boolean)FileManagerSettings.SETTINGS_EDITOR_WORD_WRAP.
                                            getDefaultValue()).booleanValue());
                            if (wordWrapSetting != activity.mWordWrap) {
                                activity.mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        toggleWordWrap();
                                    }
                                });
                            }

                        // Syntax highlight
                        // Default theme color scheme
                        // Color scheme
                        } else if (key.compareTo(FileManagerSettings.SETTINGS_EDITOR_SYNTAX_HIGHLIGHT.getId()) == 0) {
                            // Ignore in binary files
                            if (activity.mBinary) return;

                            // Do we have a different setting?
                            boolean syntaxHighlightSetting =
                                    Preferences.getSharedPreferences().getBoolean(
                                        FileManagerSettings.SETTINGS_EDITOR_SYNTAX_HIGHLIGHT.getId(),
                                        ((Boolean)FileManagerSettings.SETTINGS_EDITOR_SYNTAX_HIGHLIGHT.
                                                getDefaultValue()).booleanValue());
                            if (syntaxHighlightSetting != activity.mSyntaxHighlight) {
                                activity.mHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        toggleSyntaxHighlight();
                                    }
                                });
                            }

                        } else if (key.compareTo(FileManagerSettings.SETTINGS_EDITOR_SH_COLOR_SCHEME.getId()) == 0 ) {
                            // Ignore in binary files
                            if (activity.mBinary) return;

                            // Reload the syntax highlight
                            activity.mHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    reloadSyntaxHighlight();
                                }
                            });
                        }
                    }
                    return;
                }
            }
        }

