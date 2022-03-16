    private void sayForLocation(Long voiceSettingId, boolean initiatedFromBtDEvice) {
        VoiceSettingParametersDbHelper voiceSettingParametersDbHelper = VoiceSettingParametersDbHelper.getInstance(getBaseContext());
        final CurrentWeatherDbHelper currentWeatherDbHelper = CurrentWeatherDbHelper.getInstance(getBaseContext());
        final LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getBaseContext());

        Boolean allLocations = voiceSettingParametersDbHelper.getBooleanParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_LOCATIONS.getVoiceSettingParamTypeId());
        appendLog(getBaseContext(), TAG, "sayForLocation:allLocations:" + allLocations);
        if ((allLocations != null) && allLocations) {
            for (Location location: locationsDbHelper.getAllRows()) {
                CurrentWeatherDbHelper.WeatherRecord weatherRecord = currentWeatherDbHelper.getWeather(location.getId());
                sayCurrentWeather(
                        weatherRecord.getWeather(),
                        location,
                        weatherRecord.getLastUpdatedTime(),
                        voiceSettingId,
                        initiatedFromBtDEvice);
            }
            return;
        }
        String enabledLocationIds = voiceSettingParametersDbHelper.getStringParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_LOCATIONS.getVoiceSettingParamTypeId());
        appendLog(getBaseContext(), TAG, "sayForLocation:enabledLocationIds:" + enabledLocationIds);
        List<Location> locations = locationsDbHelper.getAllRows();
        if (locations.isEmpty()) {
            return;
        }
        for (Location location: locations) {
            if (enabledLocationIds.contains(location.getId().toString())) {
                CurrentWeatherDbHelper.WeatherRecord weatherRecord = currentWeatherDbHelper.getWeather(location.getId());
                sayCurrentWeather(
                        weatherRecord.getWeather(),
                        location,
                        weatherRecord.getLastUpdatedTime(),
                        voiceSettingId,
                        initiatedFromBtDEvice);
            }
        }
        return;
    }

