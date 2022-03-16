    public static String getLanguageName(String locale) {
        if (TextUtils.isEmpty(locale)) {
            locale = Locale.getDefault().toString();
        }
        if (locale.contains("_")) {
            return locale.split("_")[0];
        }
        return locale;
    }

