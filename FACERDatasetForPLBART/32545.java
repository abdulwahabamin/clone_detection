    private String sayRainSnow(double rain, double snow, Location location) {
        StringBuilder forecastToSay = new StringBuilder();
        if (rain > MIN_RAIN_SNOW_MM) {
            forecastToSay.append(TTS_DELAY_BETWEEN_ITEM);
            forecastToSay.append(getString(R.string.tty_say_max_rain,
                    AppPreference.getFormatedRainOrSnow(getBaseContext(), rain, location.getLocale())));
            forecastToSay.append(" ");
        }
        if (snow > MIN_RAIN_SNOW_MM) {
            forecastToSay.append(TTS_DELAY_BETWEEN_ITEM);
            forecastToSay.append(getString(R.string.tty_say_max_rain,
                    AppPreference.getFormatedRainOrSnow(getBaseContext(), snow, location.getLocale())));
            forecastToSay.append(" ");
        }
        return forecastToSay.toString();
    }

