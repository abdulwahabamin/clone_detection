    @Override
    public void onCreate() {
        super.onCreate();
        Locale locale = Locale.getDefault();
        systemLocaleCode = getSystemLocaleCode(locale);
    }

