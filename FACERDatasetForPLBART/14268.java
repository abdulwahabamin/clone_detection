    /**
     * @param context
     * @param packageName
     */
    public static void setThemePackageName(Context context, String packageName) {
        SharedPreferences sp = context.getSharedPreferences(APOLLO_PREFERENCES, 0);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(THEME_PACKAGE_NAME, packageName);
        editor.commit();
    }

