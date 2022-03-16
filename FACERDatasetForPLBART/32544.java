    private void sayCurrentWeather(Weather weather,
                                   Location currentLocation,
                                   long now,
                                   Long voiceSettingId,
                                   boolean initiatedFromBtDevice) {
        weatherByVoiceMessages.clear();
        appendLog(getBaseContext(), TAG, "sayCurrentWeather voiceSettingIdFromSettings: " + voiceSettingId + ":" + now + ":" + currentLocation);
        Long voiceSettingIdFromSettings = isAnySettingValidToTellWeather(voiceSettingId, initiatedFromBtDevice);
        appendLog(getBaseContext(), TAG, "sayCurrentWeather voiceSettingIdFromSettings: " + voiceSettingIdFromSettings);
        if (voiceSettingIdFromSettings == null) {
            return;
        }
        VoiceSettingParametersDbHelper voiceSettingParametersDbHelper = VoiceSettingParametersDbHelper.getInstance(getBaseContext());

        LinkedList<String> textToSay = new LinkedList<>();

        Long partsToSay = voiceSettingParametersDbHelper.getLongParam(
                voiceSettingIdFromSettings,
                VoiceSettingParamType.VOICE_SETTING_PARTS_TO_SAY.getVoiceSettingParamTypeId());
        if (partsToSay == null) {
            return;
        }

        if (TimeUtils.isCurrentSettingIndex(partsToSay, 0)) {
            if (TimeUtils.isCurrentSettingIndex(partsToSay, 1)) {
                textToSay.add(getCustomGreeting(voiceSettingParametersDbHelper, voiceSettingIdFromSettings));
            } else {
                textToSay.add(getString(getGreetingId()));
            }
            textToSay.add(TTS_DELAY_BETWEEN_ITEM);
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 2)) {
            if (TimeUtils.isCurrentSettingIndex(partsToSay, 3)) {
                textToSay.add(String.format(voiceSettingParametersDbHelper.getStringParam(
                        voiceSettingIdFromSettings,
                        VoiceSettingParamType.VOICE_SETTING_LOCATION_CUSTOM.getVoiceSettingParamTypeId()),
                        Utils.getLocationForVoiceFromAddress(currentLocation.getAddress())));
            } else {
                textToSay.add(getString(R.string.tts_say_current_weather_with_location,
                        Utils.getLocationForVoiceFromAddress(currentLocation.getAddress())));
            }
        } else if (TimeUtils.isCurrentSettingIndex(partsToSay, 4)) {
            if (TimeUtils.isCurrentSettingIndex(partsToSay, 5)) {
                textToSay.add(voiceSettingParametersDbHelper.getStringParam(
                        voiceSettingIdFromSettings,
                        VoiceSettingParamType.VOICE_SETTING_WEATHER_DESCRIPTION_CUSTOM.getVoiceSettingParamTypeId()));
            } else {
                textToSay.add(getString(R.string.tts_say_current_weather));
            }
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 4) || TimeUtils.isCurrentSettingIndex(partsToSay, 2)) {
            textToSay.add(TTS_DELAY_BETWEEN_ITEM);
            StringBuilder weatherDescriptionToSay = new StringBuilder();
            weatherDescriptionToSay.append(" ");
            weatherDescriptionToSay.append(Utils.getWeatherDescription(getBaseContext(), currentLocation.getLocaleAbbrev(), weather));
            weatherDescriptionToSay.append(" ");
            textToSay.add(weatherDescriptionToSay.toString());
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 6)) {
            textToSay.add(TTS_DELAY_BETWEEN_ITEM);
            StringBuilder temperatureToSay = new StringBuilder();
            if (TimeUtils.isCurrentSettingIndex(partsToSay, 7)) {
                temperatureToSay.append(String.format(voiceSettingParametersDbHelper.getStringParam(
                        voiceSettingIdFromSettings,
                        VoiceSettingParamType.VOICE_SETTING_TEMPERATURE_CUSTOM.getVoiceSettingParamTypeId()),
                        TemperatureUtil.getMeasuredTemperatureWithUnit(getBaseContext(), weather.getTemperature(), currentLocation.getLocale())));
            } else {
                temperatureToSay.append(getString(R.string.tty_say_temperature,
                        TemperatureUtil.getMeasuredTemperatureWithUnit(getBaseContext(), weather.getTemperature(), currentLocation.getLocale())));
            }
            temperatureToSay.append(" ");
            textToSay.add(temperatureToSay.toString());
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 8)) {
            textToSay.add(TTS_DELAY_BETWEEN_ITEM);
            StringBuilder windToSay = new StringBuilder();

            WindWithUnit windWithUnit = AppPreference.getWindWithUnit(getBaseContext(),
                    weather.getWindSpeed(),
                    weather.getWindDirection(),
                    currentLocation.getLocale());
            if (TimeUtils.isCurrentSettingIndex(partsToSay, 9)) {
                windToSay.append(String.format(voiceSettingParametersDbHelper.getStringParam(
                        voiceSettingIdFromSettings,
                        VoiceSettingParamType.VOICE_SETTING_WIND_CUSTOM.getVoiceSettingParamTypeId()),
                        windWithUnit.getWindSpeed(0),
                        windWithUnit.getWindUnit(),
                        windWithUnit.getWindDirectionByVoice()));
            } else {
                windToSay.append(getString(R.string.tty_say_wind,
                        windWithUnit.getWindSpeed(0),
                        windWithUnit.getWindUnit(),
                        windWithUnit.getWindDirectionByVoice()));
            }
            windToSay.append(" ");
            textToSay.add(windToSay.toString());
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 10)) {
            ForecastUtil.WeatherForecastForVoice weatherForecastForVoice = ForecastUtil.calculateWeatherVoiceForecast(getBaseContext(), currentLocation.getId());
            textToSay.add(TTS_DELAY_BETWEEN_ITEM);
            StringBuilder forecastToSay = new StringBuilder();
            int currentDayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
            forecastToSay.append(getString(R.string.tty_say_weather_forecast));
            forecastToSay.append(" ");
            if (currentDayOfYear == weatherForecastForVoice.dayOfYear) {
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_today));
                forecastToSay.append(" ");
            } else if ((currentDayOfYear + 1) == weatherForecastForVoice.dayOfYear) {
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_tomorrow));
                forecastToSay.append(" ");
            }

            String forecastCommonWeatherForecastToSay = sayCommonWeatherForecastParts(weatherForecastForVoice, currentLocation);
            if (forecastCommonWeatherForecastToSay != null) {
                forecastToSay.append(forecastCommonWeatherForecastToSay);
            }

            boolean commonPartsAreComplete = forecastCommonWeatherForecastToSay != null;
            boolean nightWeather = weatherForecastForVoice.nightWeatherIds != null;
            boolean morningWeather = weatherForecastForVoice.morningWeatherIds != null;
            boolean afternoonWeather = weatherForecastForVoice.afternoonWeatherIds != null;
            boolean eveningWeather = weatherForecastForVoice.eveningWeatherIds != null;

            if (nightWeather && !commonPartsAreComplete) {
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_night));
                forecastToSay.append(" ");
                forecastToSay.append(Utils.getWeatherDescription(weatherForecastForVoice.nightWeatherIds.mainWeatherId,
                        weatherForecastForVoice.nightWeatherIds.mainWeatherDescriptionsFromOwm,
                        currentLocation.getLocaleAbbrev(),
                        getBaseContext()));
                forecastToSay.append(" ");
                if (weatherForecastForVoice.nightWeatherIds.warningWeatherId != null) {
                    forecastToSay.append(getString(R.string.tty_say_weather_forecast_rarely));
                    forecastToSay.append(" ");
                    forecastToSay.append(Utils.getWeatherDescription(weatherForecastForVoice.nightWeatherIds.warningWeatherId,
                            weatherForecastForVoice.nightWeatherIds.warningWeatherDescriptionsFromOwm,
                            currentLocation.getLocaleAbbrev(),
                            getBaseContext()));
                    forecastToSay.append(" ");
                }
                forecastToSay.append(sayRainSnow(weatherForecastForVoice.nightWeatherMaxMin.maxRain, weatherForecastForVoice.nightWeatherMaxMin.maxSnow, currentLocation));
            }
            if (morningWeather && !commonPartsAreComplete) {
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_morning));
                forecastToSay.append(" ");
                forecastToSay.append(Utils.getWeatherDescription(weatherForecastForVoice.morningWeatherIds.mainWeatherId,
                        weatherForecastForVoice.morningWeatherIds.mainWeatherDescriptionsFromOwm,
                        currentLocation.getLocaleAbbrev(),
                        getBaseContext()));
                forecastToSay.append(" ");
                if (weatherForecastForVoice.morningWeatherIds.warningWeatherId != null) {
                    forecastToSay.append(getString(R.string.tty_say_weather_forecast_rarely));
                    forecastToSay.append(" ");
                    forecastToSay.append(Utils.getWeatherDescription(weatherForecastForVoice.morningWeatherIds.warningWeatherId,
                            weatherForecastForVoice.morningWeatherIds.warningWeatherDescriptionsFromOwm,
                            currentLocation.getLocaleAbbrev(),
                            getBaseContext()));
                    forecastToSay.append(" ");
                }
                forecastToSay.append(sayRainSnow(weatherForecastForVoice.morningWeatherMaxMin.maxRain, weatherForecastForVoice.morningWeatherMaxMin.maxSnow, currentLocation));
            }
            if (afternoonWeather && !commonPartsAreComplete) {
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_afternoon));
                forecastToSay.append(" ");
                forecastToSay.append(Utils.getWeatherDescription(weatherForecastForVoice.afternoonWeatherIds.mainWeatherId,
                        weatherForecastForVoice.afternoonWeatherIds.mainWeatherDescriptionsFromOwm,
                        currentLocation.getLocaleAbbrev(),
                        getBaseContext()));
                forecastToSay.append(" ");
                if (weatherForecastForVoice.afternoonWeatherIds.warningWeatherId != null) {
                    forecastToSay.append(getString(R.string.tty_say_weather_forecast_rarely));
                    forecastToSay.append(" ");
                    forecastToSay.append(Utils.getWeatherDescription(weatherForecastForVoice.afternoonWeatherIds.warningWeatherId,
                            weatherForecastForVoice.afternoonWeatherIds.warningWeatherDescriptionsFromOwm,
                            currentLocation.getLocaleAbbrev(),
                            getBaseContext()));
                    forecastToSay.append(" ");
                }
                forecastToSay.append(sayRainSnow(weatherForecastForVoice.afternoonWeatherMaxMin.maxRain, weatherForecastForVoice.afternoonWeatherMaxMin.maxSnow, currentLocation));
            }
            if (eveningWeather && !commonPartsAreComplete) {
                forecastToSay.append(getString(R.string.tty_say_weather_forecast_evening));
                forecastToSay.append(" ");
                forecastToSay.append(Utils.getWeatherDescription(weatherForecastForVoice.eveningWeatherIds.mainWeatherId,
                        weatherForecastForVoice.eveningWeatherIds.mainWeatherDescriptionsFromOwm,
                        currentLocation.getLocaleAbbrev(),
                        getBaseContext()));
                forecastToSay.append(" ");
                if (weatherForecastForVoice.eveningWeatherIds.warningWeatherId != null) {
                    forecastToSay.append(getString(R.string.tty_say_weather_forecast_rarely));
                    forecastToSay.append(" ");
                    forecastToSay.append(Utils.getWeatherDescription(weatherForecastForVoice.eveningWeatherIds.warningWeatherId,
                            weatherForecastForVoice.eveningWeatherIds.warningWeatherDescriptionsFromOwm,
                            currentLocation.getLocaleAbbrev(),
                            getBaseContext()));
                    forecastToSay.append(" ");
                }
                forecastToSay.append(sayRainSnow(weatherForecastForVoice.eveningWeatherMaxMin.maxRain, weatherForecastForVoice.eveningWeatherMaxMin.maxSnow, currentLocation));
            }
            forecastToSay.append(TTS_DELAY_BETWEEN_ITEM);

            if ((weatherForecastForVoice.minTempTime != null) && (weatherForecastForVoice.maxTempTime != null)) {
                if (Math.round(weatherForecastForVoice.minTempForDay) == Math.round(weatherForecastForVoice.maxTempForDay)) {
                    if (weatherForecastForVoice.minTempForDay >= 0) {
                        forecastToSay.append(getString(R.string.tty_say_temp_max,
                                TemperatureUtil.getMeasuredTemperatureWithUnit(getBaseContext(), weatherForecastForVoice.minTempForDay, currentLocation.getLocale()),
                                AppPreference.getLocalizedTime(getBaseContext(), new Date(weatherForecastForVoice.minTempTime), currentLocation.getLocale())));
                        forecastToSay.append(" ");
                    } else {
                        forecastToSay.append(getString(R.string.tty_say_temp_min,
                                TemperatureUtil.getMeasuredTemperatureWithUnit(getBaseContext(), weatherForecastForVoice.minTempForDay, currentLocation.getLocale()),
                                AppPreference.getLocalizedTime(getBaseContext(), new Date(weatherForecastForVoice.minTempTime), currentLocation.getLocale())));
                        forecastToSay.append(" ");
                    }
                } else {
                    if (weatherForecastForVoice.minTempTime < weatherForecastForVoice.maxTempTime) {
                        forecastToSay.append(getString(R.string.tty_say_temp_min,
                                TemperatureUtil.getMeasuredTemperatureWithUnit(getBaseContext(), weatherForecastForVoice.minTempForDay, currentLocation.getLocale()),
                                AppPreference.getLocalizedTime(getBaseContext(), new Date(weatherForecastForVoice.minTempTime), currentLocation.getLocale())));
                        forecastToSay.append(" ");
                        forecastToSay.append(getString(R.string.tty_say_temp_max,
                                TemperatureUtil.getMeasuredTemperatureWithUnit(getBaseContext(), weatherForecastForVoice.maxTempForDay, currentLocation.getLocale()),
                                AppPreference.getLocalizedTime(getBaseContext(), new Date(weatherForecastForVoice.maxTempTime), currentLocation.getLocale())));
                        forecastToSay.append(" ");
                    } else {
                        forecastToSay.append(getString(R.string.tty_say_temp_max,
                                TemperatureUtil.getMeasuredTemperatureWithUnit(getBaseContext(), weatherForecastForVoice.maxTempForDay, currentLocation.getLocale()),
                                AppPreference.getLocalizedTime(getBaseContext(), new Date(weatherForecastForVoice.maxTempTime), currentLocation.getLocale())));
                        forecastToSay.append(" ");
                        forecastToSay.append(getString(R.string.tty_say_temp_min,
                                TemperatureUtil.getMeasuredTemperatureWithUnit(getBaseContext(), weatherForecastForVoice.minTempForDay, currentLocation.getLocale()),
                                AppPreference.getLocalizedTime(getBaseContext(), new Date(weatherForecastForVoice.minTempTime), currentLocation.getLocale())));
                        forecastToSay.append(" ");
                    }
                }
            } else {
                appendLog(getBaseContext(), TAG, "min a max time null: ", weatherForecastForVoice.minTempTime, weatherForecastForVoice.maxTempTime, weatherForecastForVoice.minTempForDay, weatherForecastForVoice.maxTempForDay);
            }
            forecastToSay.append(TTS_DELAY_BETWEEN_ITEM);
            WindWithUnit windWithUnit = AppPreference.getWindWithUnit(getBaseContext(),
                    (float)weatherForecastForVoice.maxWindForDay,
                    (float)weatherForecastForVoice.windDegreeForDay,
                    currentLocation.getLocale());
            forecastToSay.append(getString(R.string.tty_say_max_wind,
                    windWithUnit.getWindSpeed(0),
                    windWithUnit.getWindUnit(),
                    windWithUnit.getWindDirectionByVoice()));
            forecastToSay.append(" ");
            textToSay.add(forecastToSay.toString());
        }
        textToSay.add(TTS_END);
        sayWeather(textToSay);
    }

