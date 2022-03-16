    private String sayCommonWeatherForecastParts(ForecastUtil.WeatherForecastForVoice weatherForecastForVoice,
                                                 Location currentLocation) {

        boolean nightWeather = weatherForecastForVoice.nightWeatherIds != null;
        boolean morningWeather = weatherForecastForVoice.morningWeatherIds != null;
        boolean afternoonWeather = weatherForecastForVoice.afternoonWeatherIds != null;
        boolean eveningWeather = weatherForecastForVoice.eveningWeatherIds != null;
        boolean nightMorningAreSame = false;
        boolean nightMorningWarningAreSame = false;
        boolean morningAfternoonAreSame = false;
        boolean morningEveningAreSame = false;
        boolean afternoonEveningAreSame = false;
        boolean morningAfternoonWarningAreSame = false;
        boolean morningEveningWarningAreSame = false;
        boolean afternoonEveningWarningAreSame = false;
        double nightMorningAreSameMaxRain = 0;
        double nightMorningAreSameMaxSnow = 0;
        double morningAfternoonAreSameMaxRain = 0;
        double morningAfternoonAreSameMaxSnow = 0;
        double morningEveningAreSameMaxRain = 0;
        double morningEveningAreSameMaxSnow = 0;
        double afternoonEveningAreSameMaxRain = 0;
        double afternoonEveningAreSameMaxSnow = 0;

        appendLog(getBaseContext(), TAG,"sayCommonWeatherForecastParts:" + nightWeather + ":" + morningWeather + ":" + afternoonWeather + ':' + eveningWeather);

        if (nightWeather && morningWeather) {
            nightMorningAreSame = weatherForecastForVoice.nightWeatherIds.mainWeatherId.equals(weatherForecastForVoice.morningWeatherIds.mainWeatherId);
            nightMorningWarningAreSame = (weatherForecastForVoice.nightWeatherIds.warningWeatherId != null) && weatherForecastForVoice.nightWeatherIds.warningWeatherId.equals(weatherForecastForVoice.morningWeatherIds.warningWeatherId);
            appendLog(getBaseContext(), TAG,"sayCommonWeatherForecastParts:nightWeatherIds:morningWeatherIds:" + weatherForecastForVoice.nightWeatherIds.mainWeatherId + ":" + weatherForecastForVoice.morningWeatherIds.mainWeatherId + ":" + nightMorningAreSame);
            if ((weatherForecastForVoice.nightWeatherMaxMin.maxRain > MIN_RAIN_SNOW_MM) && (weatherForecastForVoice.morningWeatherMaxMin.maxRain < weatherForecastForVoice.nightWeatherMaxMin.maxRain)) {
                nightMorningAreSameMaxRain = weatherForecastForVoice.nightWeatherMaxMin.maxRain;
            } else if (weatherForecastForVoice.morningWeatherMaxMin.maxRain > MIN_RAIN_SNOW_MM) {
                nightMorningAreSameMaxRain = weatherForecastForVoice.morningWeatherMaxMin.maxRain;
            }
            if ((weatherForecastForVoice.nightWeatherMaxMin.maxSnow > MIN_RAIN_SNOW_MM) && (weatherForecastForVoice.morningWeatherMaxMin.maxSnow < weatherForecastForVoice.nightWeatherMaxMin.maxSnow)) {
                nightMorningAreSameMaxSnow = weatherForecastForVoice.nightWeatherMaxMin.maxSnow;
            } else if (weatherForecastForVoice.morningWeatherMaxMin.maxSnow > MIN_RAIN_SNOW_MM) {
                nightMorningAreSameMaxSnow = weatherForecastForVoice.morningWeatherMaxMin.maxSnow;
            }
        }
        if (morningWeather && afternoonWeather) {
            morningAfternoonAreSame = weatherForecastForVoice.morningWeatherIds.mainWeatherId.equals(weatherForecastForVoice.afternoonWeatherIds.mainWeatherId);
            morningAfternoonWarningAreSame = (weatherForecastForVoice.morningWeatherIds.warningWeatherId != null) && weatherForecastForVoice.morningWeatherIds.warningWeatherId.equals(weatherForecastForVoice.afternoonWeatherIds.warningWeatherId);

            appendLog(getBaseContext(), TAG,"sayCommonWeatherForecastParts:morningWeatherIds:afternoonWeatherIds:" + weatherForecastForVoice.morningWeatherIds.mainWeatherId + ":" + weatherForecastForVoice.afternoonWeatherIds.mainWeatherId + ":" + morningAfternoonAreSame);
            if ((weatherForecastForVoice.morningWeatherMaxMin.maxRain > MIN_RAIN_SNOW_MM) && (weatherForecastForVoice.afternoonWeatherMaxMin.maxRain < weatherForecastForVoice.morningWeatherMaxMin.maxRain)) {
                morningAfternoonAreSameMaxRain = weatherForecastForVoice.morningWeatherMaxMin.maxRain;
            } else if (weatherForecastForVoice.afternoonWeatherMaxMin.maxRain > MIN_RAIN_SNOW_MM) {
                morningAfternoonAreSameMaxRain = weatherForecastForVoice.afternoonWeatherMaxMin.maxRain;
            }
            if ((weatherForecastForVoice.morningWeatherMaxMin.maxSnow > MIN_RAIN_SNOW_MM) && (weatherForecastForVoice.afternoonWeatherMaxMin.maxSnow < weatherForecastForVoice.morningWeatherMaxMin.maxSnow)) {
                morningAfternoonAreSameMaxSnow = weatherForecastForVoice.morningWeatherMaxMin.maxSnow;
            } else if (weatherForecastForVoice.afternoonWeatherMaxMin.maxSnow > MIN_RAIN_SNOW_MM) {
                morningAfternoonAreSameMaxSnow = weatherForecastForVoice.afternoonWeatherMaxMin.maxSnow;
            }
        }
        if (morningWeather && eveningWeather) {

            morningEveningAreSame = weatherForecastForVoice.morningWeatherIds.mainWeatherId.equals(weatherForecastForVoice.eveningWeatherIds.mainWeatherId);
            morningEveningWarningAreSame = (weatherForecastForVoice.morningWeatherIds.warningWeatherId != null) && weatherForecastForVoice.morningWeatherIds.warningWeatherId.equals(weatherForecastForVoice.eveningWeatherIds.warningWeatherId);

            appendLog(getBaseContext(), TAG,"sayCommonWeatherForecastParts:morningWeatherIds:eveningWeatherIds:" + weatherForecastForVoice.morningWeatherIds.mainWeatherId + ":" + weatherForecastForVoice.eveningWeatherIds.mainWeatherId + ":" + morningEveningAreSame);
            if ((weatherForecastForVoice.morningWeatherMaxMin.maxRain > MIN_RAIN_SNOW_MM) && (weatherForecastForVoice.eveningWeatherMaxMin.maxRain < weatherForecastForVoice.morningWeatherMaxMin.maxRain)) {
                morningEveningAreSameMaxRain = weatherForecastForVoice.morningWeatherMaxMin.maxRain;
            } else if (weatherForecastForVoice.eveningWeatherMaxMin.maxRain > MIN_RAIN_SNOW_MM) {
                morningEveningAreSameMaxRain = weatherForecastForVoice.eveningWeatherMaxMin.maxRain;
            }
            if ((weatherForecastForVoice.morningWeatherMaxMin.maxSnow > MIN_RAIN_SNOW_MM) && (weatherForecastForVoice.eveningWeatherMaxMin.maxSnow < weatherForecastForVoice.morningWeatherMaxMin.maxSnow)) {
                morningEveningAreSameMaxSnow = weatherForecastForVoice.morningWeatherMaxMin.maxSnow;
            } else if (weatherForecastForVoice.eveningWeatherMaxMin.maxSnow > MIN_RAIN_SNOW_MM) {
                morningEveningAreSameMaxSnow = weatherForecastForVoice.eveningWeatherMaxMin.maxSnow;
            }
        }
        if (afternoonWeather && eveningWeather) {
            afternoonEveningAreSame = weatherForecastForVoice.afternoonWeatherIds.mainWeatherId.equals(weatherForecastForVoice.eveningWeatherIds.mainWeatherId);
            afternoonEveningWarningAreSame = (weatherForecastForVoice.afternoonWeatherIds.warningWeatherId != null) && weatherForecastForVoice.afternoonWeatherIds.warningWeatherId.equals(weatherForecastForVoice.eveningWeatherIds.warningWeatherId);

            appendLog(getBaseContext(), TAG,"sayCommonWeatherForecastParts:afternoonWeatherIds:eveningWeatherIds:" + weatherForecastForVoice.afternoonWeatherIds.mainWeatherId + ":" + weatherForecastForVoice.eveningWeatherIds.mainWeatherId + ":" + afternoonEveningAreSame);
            if ((weatherForecastForVoice.afternoonWeatherMaxMin.maxRain > MIN_RAIN_SNOW_MM) && (weatherForecastForVoice.eveningWeatherMaxMin.maxRain < weatherForecastForVoice.afternoonWeatherMaxMin.maxRain)) {
                afternoonEveningAreSameMaxRain = weatherForecastForVoice.afternoonWeatherMaxMin.maxRain;
            } else if (weatherForecastForVoice.eveningWeatherMaxMin.maxRain > MIN_RAIN_SNOW_MM) {
                afternoonEveningAreSameMaxRain = weatherForecastForVoice.eveningWeatherMaxMin.maxRain;
            }
            if ((weatherForecastForVoice.afternoonWeatherMaxMin.maxSnow > MIN_RAIN_SNOW_MM) && (weatherForecastForVoice.eveningWeatherMaxMin.maxSnow < weatherForecastForVoice.afternoonWeatherMaxMin.maxSnow)) {
                afternoonEveningAreSameMaxSnow = weatherForecastForVoice.afternoonWeatherMaxMin.maxSnow;
            } else if (weatherForecastForVoice.eveningWeatherMaxMin.maxSnow > MIN_RAIN_SNOW_MM) {
                afternoonEveningAreSameMaxSnow = weatherForecastForVoice.eveningWeatherMaxMin.maxSnow;
            }
        }

        double maxRain = Math.max(Math.max(Math.max(nightMorningAreSameMaxRain, morningAfternoonAreSameMaxRain), morningEveningAreSameMaxRain), afternoonEveningAreSameMaxRain);
        double maxSnow = Math.max(Math.max(Math.max(nightMorningAreSameMaxSnow, morningAfternoonAreSameMaxSnow), morningEveningAreSameMaxSnow), afternoonEveningAreSameMaxSnow);

        if ((!nightWeather || nightMorningAreSame) &&
                (!morningWeather || morningAfternoonAreSame) &&
                (!morningWeather || morningEveningAreSame) &&
                (!afternoonWeather || afternoonEveningAreSame)) {
            StringBuilder forecastToSay = null;
            forecastToSay = new StringBuilder();
            Integer mainWeatherId;
            String mainWeatherDescription;
            Integer warningWeatherId;
            String warningWeatherDescription;
            if (weatherForecastForVoice.nightWeatherIds != null) {
                mainWeatherId = weatherForecastForVoice.nightWeatherIds.mainWeatherId;
                mainWeatherDescription = weatherForecastForVoice.nightWeatherIds.mainWeatherDescriptionsFromOwm;
                warningWeatherId = weatherForecastForVoice.nightWeatherIds.warningWeatherId;
                warningWeatherDescription = weatherForecastForVoice.nightWeatherIds.warningWeatherDescriptionsFromOwm;
            } else if (weatherForecastForVoice.morningWeatherIds != null) {
                mainWeatherId = weatherForecastForVoice.morningWeatherIds.mainWeatherId;
                mainWeatherDescription = weatherForecastForVoice.morningWeatherIds.mainWeatherDescriptionsFromOwm;
                warningWeatherId = weatherForecastForVoice.morningWeatherIds.warningWeatherId;
                warningWeatherDescription = weatherForecastForVoice.morningWeatherIds.warningWeatherDescriptionsFromOwm;
            } else if (weatherForecastForVoice.afternoonWeatherIds != null) {
                mainWeatherId = weatherForecastForVoice.afternoonWeatherIds.mainWeatherId;
                mainWeatherDescription = weatherForecastForVoice.afternoonWeatherIds.mainWeatherDescriptionsFromOwm;
                warningWeatherId = weatherForecastForVoice.afternoonWeatherIds.warningWeatherId;
                warningWeatherDescription = weatherForecastForVoice.afternoonWeatherIds.warningWeatherDescriptionsFromOwm;
            } else {
                mainWeatherId = weatherForecastForVoice.nightWeatherIds.mainWeatherId;
                mainWeatherDescription = weatherForecastForVoice.nightWeatherIds.mainWeatherDescriptionsFromOwm;
                warningWeatherId = weatherForecastForVoice.nightWeatherIds.warningWeatherId;
                warningWeatherDescription = weatherForecastForVoice.nightWeatherIds.warningWeatherDescriptionsFromOwm;
            }
            forecastToSay.append(Utils.getWeatherDescription(mainWeatherId,
                    mainWeatherDescription,
                    currentLocation.getLocaleAbbrev(),
                    getBaseContext()));
            if (nightMorningWarningAreSame && morningAfternoonWarningAreSame && morningEveningWarningAreSame && afternoonEveningWarningAreSame) {
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_rarely));
                forecastToSay.append(" ");
                forecastToSay.append(Utils.getWeatherDescription(warningWeatherId,
                        warningWeatherDescription,
                        currentLocation.getLocaleAbbrev(),
                        getBaseContext()));
            }
            forecastToSay.append(sayRainSnow(maxRain, maxSnow, currentLocation));
            return forecastToSay.toString();
        }
        if (nightMorningAreSame) {
            StringBuilder forecastToSay = null;
            forecastToSay = new StringBuilder();
            if (morningAfternoonAreSame) {
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_night));
                forecastToSay.append(", ");
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_morning));
                forecastToSay.append(" ");
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_and));
                forecastToSay.append(" ");
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_afternoon));
                forecastToSay.append(" ");
            } else {
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_night));
                forecastToSay.append(" ");
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_and));
                forecastToSay.append(" ");
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_morning));
                forecastToSay.append(" ");
            }
            forecastToSay.append(Utils.getWeatherDescription(weatherForecastForVoice.morningWeatherIds.mainWeatherId,
                    weatherForecastForVoice.morningWeatherIds.mainWeatherDescriptionsFromOwm,
                    currentLocation.getLocaleAbbrev(),
                    getBaseContext()));
            forecastToSay.append(" ");
        }
        if (morningAfternoonAreSame) {
            StringBuilder forecastToSay = null;
            forecastToSay = new StringBuilder();
            if (!nightMorningAreSame) {
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_morning));
                forecastToSay.append(" ");
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_and));
                forecastToSay.append(" ");
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_afternoon));
                forecastToSay.append(" ");
                forecastToSay.append(Utils.getWeatherDescription(weatherForecastForVoice.morningWeatherIds.mainWeatherId,
                        weatherForecastForVoice.morningWeatherIds.mainWeatherDescriptionsFromOwm,
                        currentLocation.getLocaleAbbrev(),
                        getBaseContext()));
                forecastToSay.append(" ");
            }
            if (eveningWeather) {
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_evening));
                forecastToSay.append(" ");
                forecastToSay.append(Utils.getWeatherDescription(weatherForecastForVoice.eveningWeatherIds.mainWeatherId,
                        weatherForecastForVoice.eveningWeatherIds.mainWeatherDescriptionsFromOwm,
                        currentLocation.getLocaleAbbrev(),
                        getBaseContext()));
                forecastToSay.append(" ");
            }
            forecastToSay.append(sayRainSnow(maxRain, maxSnow, currentLocation));
            return forecastToSay.toString();
        } else if (morningEveningAreSame) {
            StringBuilder forecastToSay = null;
            forecastToSay = new StringBuilder();
            forecastToSay.append(getString(R.string.tty_say_weather_forecast_morning));
            forecastToSay.append(" ");
            forecastToSay.append(getString(R.string.tty_say_weather_forecast_and));
            forecastToSay.append(" ");
            forecastToSay.append(getString(R.string.tty_say_weather_forecast_evening));
            forecastToSay.append(" ");
            forecastToSay.append(Utils.getWeatherDescription(weatherForecastForVoice.morningWeatherIds.mainWeatherId,
                    weatherForecastForVoice.morningWeatherIds.mainWeatherDescriptionsFromOwm,
                    currentLocation.getLocaleAbbrev(),
                    getBaseContext()));
            forecastToSay.append(" ");
            if (afternoonWeather) {
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_afternoon));
                forecastToSay.append(" ");
                forecastToSay.append(Utils.getWeatherDescription(weatherForecastForVoice.eveningWeatherIds.mainWeatherId,
                        weatherForecastForVoice.eveningWeatherIds.mainWeatherDescriptionsFromOwm,
                        currentLocation.getLocaleAbbrev(),
                        getBaseContext()));
                forecastToSay.append(" ");
            }
            forecastToSay.append(sayRainSnow(maxRain, maxSnow, currentLocation));
            forecastToSay.append(" ");
            return forecastToSay.toString();
        } else if (afternoonEveningAreSame) {
            StringBuilder forecastToSay = null;
            forecastToSay = new StringBuilder();
            if (morningWeather) {
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_morning));
                forecastToSay.append(" ");
                forecastToSay.append(Utils.getWeatherDescription(weatherForecastForVoice.eveningWeatherIds.mainWeatherId,
                        weatherForecastForVoice.eveningWeatherIds.mainWeatherDescriptionsFromOwm,
                        currentLocation.getLocaleAbbrev(),
                        getBaseContext()));
                forecastToSay.append(" ");
            }
            forecastToSay.append(getString(R.string.tty_say_weather_forecast_afternoon));
            forecastToSay.append(" ");
            forecastToSay.append(getString(R.string.tty_say_weather_forecast_and));
            forecastToSay.append(" ");
            forecastToSay.append(getString(R.string.tty_say_weather_forecast_evening));
            forecastToSay.append(" ");
            forecastToSay.append(Utils.getWeatherDescription(weatherForecastForVoice.morningWeatherIds.mainWeatherId,
                    weatherForecastForVoice.morningWeatherIds.mainWeatherDescriptionsFromOwm,
                    currentLocation.getLocaleAbbrev(),
                    getBaseContext()));
            forecastToSay.append(" ");
            forecastToSay.append(sayRainSnow(maxRain, maxSnow, currentLocation));
            forecastToSay.append(" ");
            return forecastToSay.toString();
        }
        return null;
    }

