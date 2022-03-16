    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Locale locale = newConfig.locale;
        systemLocaleCode = getSystemLocaleCode(locale);
    }

