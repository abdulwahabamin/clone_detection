    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Configuration config = getBaseContext().getResources().getConfiguration();

        String lang = preferences.getString(getString(R.string.pref_language) , "en");
        locale = new Locale(lang);
        config.setLocale(locale);
        Log.i("Locale" , lang);
        Locale.setDefault(locale);
        updateConfiguration(config);
        setSystemLocale(config , locale);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
            LanguageUtil.setLanguage(this, new Prefs(this).getLanguage());
    }

