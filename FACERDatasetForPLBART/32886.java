    public static long getLastUpdateTimeInMilis(
                                         CurrentWeatherDbHelper.WeatherRecord weatherRecord,
                                         WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord,
                                         Location location) {
        List<Long> lastUpdateTimes = new ArrayList<>();
        lastUpdateTimes.add((weatherForecastRecord != null)?weatherForecastRecord.getLastUpdatedTime():0);
        lastUpdateTimes.add((weatherRecord != null)?weatherRecord.getLastUpdatedTime():0);
        lastUpdateTimes.add((location != null)?location.getLastLocationUpdate():0);

        return Collections.max(lastUpdateTimes);
    }

