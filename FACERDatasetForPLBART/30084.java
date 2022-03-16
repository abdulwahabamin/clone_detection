    @TargetApi(17)
    @SuppressWarnings("deprecation")
    public static void setLanguage(final ContextWrapper contextWrapper, String locale) {
        Locale sLocale;
        if (TextUtils.isEmpty(locale)) {
            sLocale = Locale.getDefault();
        } else {
            String[] localeParts = locale.split("_");
            if (localeParts.length > 1) {
                sLocale = new Locale(localeParts[0], localeParts[1]);
            } else {
                sLocale = new Locale(locale);
            }
        }

        Resources resources = contextWrapper.getBaseContext().getResources();
        Configuration configuration = resources.getConfiguration();
        Locale.setDefault(sLocale);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(sLocale);
        } else {
            configuration.locale = sLocale;
        }

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

