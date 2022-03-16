    /**
     * Method that loads the default color scheme
     *
     * @param reset Whether the color scheme should be reseted
     * @hide
     */
    void loadDefaultColorScheme(boolean reset) {
        try {
            String defaultValue =
                    (String)FileManagerSettings.SETTINGS_EDITOR_SH_COLOR_SCHEME.getDefaultValue();
            if (!reset) {
                defaultValue =
                        Preferences.getSharedPreferences().getString(
                            FileManagerSettings.SETTINGS_EDITOR_SH_COLOR_SCHEME.getId(),
                            defaultValue);
            } else {
                Preferences.savePreference(
                        FileManagerSettings.SETTINGS_EDITOR_SH_COLOR_SCHEME,
                        defaultValue,
                        true);
            }
            int[] colorScheme = toColorShemeArray(defaultValue);
            HighlightColors[] colors = HighlightColors.values();
            int cc = colors.length;
            this.mColorScheme = new ColorPickerPreference[cc];
            for (int i = 0; i < cc; i++) {
                this.mColorScheme[i] = (ColorPickerPreference)findPreference(colors[i].getId());
                setColorScheme(colors[i], colorScheme, i);
                this.mColorScheme[i].setOnPreferenceChangeListener(this.mOnChangeListener);
            }
        } catch (Exception e) {
            ExceptionUtil.translateException(getActivity(), e);
        }
    }

