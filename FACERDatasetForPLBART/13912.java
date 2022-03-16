    private static void setSharedPref(String key, String value, Context context) {
        musicPreference = context.getSharedPreferences(AppConstant.PREF_NAME, 0);
        SharedPreferences.Editor musicPreferenceEditor = musicPreference.edit();
        musicPreferenceEditor.putString(key, value);
        musicPreferenceEditor.apply();
    }

