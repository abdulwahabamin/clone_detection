    /**
     * @param context
     * @param default_theme
     * @return theme package name
     */
    public static String getThemePackageName(Context context, String default_theme) {
        SharedPreferences sp = context.getSharedPreferences(APOLLO_PREFERENCES, 0);
        return sp.getString(THEME_PACKAGE_NAME, default_theme);
    }

