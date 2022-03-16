    /**
     * Method that returns the default theme
     *
     * @param ctx The current context
     * @return Theme The default theme
     */
    public static synchronized Theme getDefaultTheme(Context ctx) {
        if (mDefaultTheme == null) {
            // Use the default theme
            mDefaultTheme = new Theme();
            String themeSettings = (String)FileManagerSettings.SETTINGS_THEME.getDefaultValue();
            mDefaultTheme.mPackage =
                    themeSettings.substring(0, themeSettings.indexOf(":")); //$NON-NLS-1$
            mDefaultTheme.mId =
                    themeSettings.substring(themeSettings.indexOf(":") + 1); //$NON-NLS-1$
            mDefaultTheme.mName = ctx.getString(R.string.theme_default_name);
            mDefaultTheme.mDescription = ctx.getString(R.string.theme_default_description);
            mDefaultTheme.mAuthor = ctx.getString(R.string.themes_author);

            mDefaultTheme.mContext = ctx;
            mDefaultTheme.mResources = ctx.getResources();
        }
        return mDefaultTheme;
    }

