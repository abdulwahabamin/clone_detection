    public static String getWeatherDescription(Context context, String locale, Weather weather) {
        if(AppPreference.hideDescription(context)) {
            return " ";
        }
        StringBuilder currentWeatherDescription = new StringBuilder();
        boolean first = true;
        for (CurrentWeather currentWeather: weather.getCurrentWeathers()) {
            if (!first) {
                currentWeatherDescription.append(", ");
            }
            currentWeatherDescription.append(getWeatherDescription(
                    currentWeather.getWeatherId(),
                    currentWeather.getDescription(),
                    locale,
                    context));
            first = false;
        }
        return currentWeatherDescription.toString();
    }

