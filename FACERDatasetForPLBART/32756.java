    public static Context setLanguage(final Context context, String locale) {
        Locale sLocale;
        if (TextUtils.isEmpty(locale) || "default".equals(locale)) {
            sLocale = Locale.getDefault();
        } else {
            String[] localeParts = locale.split("-");
            appendLogLocale(context,
                    TAG,
                    "locale.split(\"_-\"):",
                    localeParts,
                    ":locale:",
                    locale);
            if (localeParts.length > 1) {
                sLocale = new Locale(localeParts[0], localeParts[1]);
            } else {
                sLocale = new Locale(locale);
            }
        }

        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale.setDefault(sLocale);
        Context newContext = context;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(sLocale);
            newContext = context.createConfigurationContext(configuration);
        } else {
            configuration.locale = sLocale;
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return newContext;
    }

