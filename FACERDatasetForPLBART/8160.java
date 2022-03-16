        /**
         * Method that returns the user-defined color scheme
         *
         * @return int[] The user-defined color scheme
         */
        private int[] getUserColorScheme() {
            String defaultValue =
                    (String)FileManagerSettings.
                                SETTINGS_EDITOR_SH_COLOR_SCHEME.getDefaultValue();
            String value = Preferences.getSharedPreferences().getString(
                                FileManagerSettings.SETTINGS_EDITOR_SH_COLOR_SCHEME.getId(),
                                defaultValue);
            return EditorSHColorSchemePreferenceFragment.toColorShemeArray(value);
        }

