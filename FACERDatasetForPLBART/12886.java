    /**
     * A method for set the current theme that should be applied to the UI.
     *
     * @param ctx The current context (of this application)
     * @param theme The theme of the app (package:id)
     * @return boolean If the theme was set
     */
    public static synchronized boolean setCurrentTheme(Context ctx, String theme) {
        // Retrieve the available themes
        List<Theme> themes = getAvailableThemes(ctx);
        String themePackage = theme.substring(0, theme.indexOf(":")); //$NON-NLS-1$
        String themeId = theme.substring(theme.indexOf(":") + 1); //$NON-NLS-1$
        int cc = themes.size();
        for (int i = 0; i < cc; i++) {
            Theme t = themes.get(i);
            if (t.mPackage.compareTo(themePackage) == 0 && t.mId.compareTo(themeId) == 0) {
                // We have the theme. Save it and notify
                mCurrentTheme = t;

                Intent intent = new Intent(FileManagerSettings.INTENT_THEME_CHANGED);
                intent.putExtra(FileManagerSettings.EXTRA_THEME_PACKAGE, t.mPackage);
                intent.putExtra(FileManagerSettings.EXTRA_THEME_ID, t.mId);
                ctx.sendBroadcast(intent);
                return true;
            }
        }

        // Not found
        return false;
    }

