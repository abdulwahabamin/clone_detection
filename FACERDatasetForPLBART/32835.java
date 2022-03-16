    public static String getLanguage(Context context) {
        String language = PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.PREF_LANGUAGE, Resources.getSystem().getConfiguration().locale.getLanguage());
        if ("default".equals(language)) {
            language = PreferenceManager.getDefaultSharedPreferences(context).getString(Constants.PREF_OS_LANGUAGE, Resources.getSystem().getConfiguration().locale.getLanguage());
        }
        return language;
    }

