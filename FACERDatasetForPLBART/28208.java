    public static void setTheme(Context context, boolean isNightModeEnabled) {
        setIsNightModeEnabled(context, isNightModeEnabled);
        if (isNightModeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

