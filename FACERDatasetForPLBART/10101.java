    /**
     * Method that returns if the theme is the default theme
     *
     * @param theme The theme to check
     * @return boolean Id the current theme is the default theme
     */
    public static boolean isDefaultTheme(Theme theme) {
        String themeSettings = (String)FileManagerSettings.SETTINGS_THEME.getDefaultValue();
        String defaultPackage =
                themeSettings.substring(0, themeSettings.indexOf(":")); //$NON-NLS-1$
        String defaultId =
                themeSettings.substring(themeSettings.indexOf(":") + 1); //$NON-NLS-1$
        return theme.mPackage.compareTo(defaultPackage) == 0 &&
               theme.mId.compareTo(defaultId) == 0;
    }

