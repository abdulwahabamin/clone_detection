    /**
     * Method that returns if the preference is part of the color scheme preferences
     *
     * @return boolean Whether preference is part of the color scheme preferences
     * @hide
     */
    static boolean isColorSchemePreference(final Preference preference) {
        String key = preference.getKey();
        if (key == null) {
            return false;
        }
        HighlightColors[] colors = HighlightColors.values();
        int cc = colors.length;
        for (int i = 0; i < cc; i++) {
            if (colors[i].getId().compareTo(key) == 0) {
                return true;
            }
        }
        return false;
    }

