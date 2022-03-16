    public static String getWeatherDescription(int weatherId, String weatherDescriptionFromOwm, String locale, Context context) {
        String weatherDescription;
        if ((weatherDescriptionFromOwm == null) || !OWMLanguages.isLanguageSupportedByOWMAndNotTranslatedLocaly(locale)) {
            weatherDescription = context.getString(getWeatherDescriptionResourceId(weatherId));
        } else {
            weatherDescription = capitalizeFirstLetter(weatherDescriptionFromOwm);
        }
        return weatherDescription;
    }

