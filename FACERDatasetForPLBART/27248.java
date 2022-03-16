    public static String getDefaultUnit() {
        String countryCode = Locale.getDefault().getCountry();
        // USA, Liberia, Burma - Imperial , all others countries - metric
        if ("US".equals(countryCode) || "LR".equals(countryCode) || "MM".equals(countryCode)){
            return "imperial";
        }
        return "metric";
    }

