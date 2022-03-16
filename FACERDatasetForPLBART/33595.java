    /**
     * Updates locale for app process.
     *
     * @param localeCode language and (optionally) country code, defined by ISO, eg. pt-rBR for
     *                   Portuguese in Brazil
     * @param res        app resources
     */
    public static void updateLocale(String localeCode, Resources res) {
        Locale locale;
        if (localeCode.contains("-r") || localeCode.contains("-")) {
            final String[] language_region = localeCode.split("\\-(r)?");
            locale = new Locale(language_region[0], language_region[1]);
        } else {
            locale = new Locale(localeCode);
        }
        Configuration config = res.getConfiguration();
        config.locale = locale;
        res.updateConfiguration(config, res.getDisplayMetrics());
        Locale.setDefault(locale);
    }

