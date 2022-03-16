    /**
     * Method that converts all the color scheme preference to one unified preference set
     *
     * @param preference The color scheme preference that was changed
     * @param newValue The new value of the color scheme
     * @return colorScheme The actual color schemes
     * @hide
     */
    String toColorSchemeSet(final Preference preference, final int newValue) {
        int cc = this.mColorScheme.length;
        String[] colorSchemes = new String[cc];
        for (int i = 0; i < cc; i++) {
            String prop = String.valueOf(this.mColorScheme[i].getColor());
            if (this.mColorScheme[i].getKey().compareTo(preference.getKey()) == 0) {
                prop = String.valueOf(newValue);
            }
            colorSchemes[i] = prop;
        }
        return TextUtils.join("|", colorSchemes); //$NON-NLS-1$
    }

