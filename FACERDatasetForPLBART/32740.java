    public static WeatherForecastForVoice calculateWeatherVoiceForecast(Context context, Long locationId) {
        final WeatherForecastDbHelper weatherForecastDbHelper = WeatherForecastDbHelper.getInstance(context);
        WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord = weatherForecastDbHelper.getWeatherForecast(locationId);
        Map<Integer, List<DetailedWeatherForecast>> weatherListForOneDay = getOneDayForecast(weatherForecastRecord);
        WeatherForecastForVoice result = new WeatherForecastForVoice();
        double maxTemp = -Double.MAX_VALUE;
        double minTemp = Double.MAX_VALUE;
        double maxWind = 0;
        double windDegreeForDay = 0;
        Long maxRainTime = null;
        Long maxSnowTime = null;
        Long maxTempTime = null;
        Long minTempTime = null;
        Long maxWindTime = null;
        for (int i = 0; i < 4; i++) {
            List<DetailedWeatherForecast> periodWeatherCondition = weatherListForOneDay.get(i);
            if (periodWeatherCondition == null) {
                continue;
            }
            WeatherMaxMinForDay weatherMaxMinForPeriod = calculateWeatherMaxMinForDay(periodWeatherCondition);
            if (weatherMaxMinForPeriod == null) {
                continue;
            }
            WeatherIdsForDay weatherIdsForPeriod = getWeatherIdForDay(periodWeatherCondition, weatherMaxMinForPeriod);
            if (i == 0) {
                result.nightWeatherIds = weatherIdsForPeriod;
                result.nightWeatherMaxMin = weatherMaxMinForPeriod;
                if (maxTemp < result.nightWeatherMaxMin.maxTemp) {
                    maxTemp = result.nightWeatherMaxMin.maxTemp;
                    maxTempTime = result.nightWeatherMaxMin.maxTempTime;
                }
                if (minTemp > result.nightWeatherMaxMin.minTemp) {
                    minTemp = result.nightWeatherMaxMin.minTemp;
                    minTempTime = result.nightWeatherMaxMin.minTempTime;
                }
                if (maxWind < result.nightWeatherMaxMin.maxWind) {
                    maxWind = result.nightWeatherMaxMin.maxWind;
                    windDegreeForDay = result.nightWeatherMaxMin.windDegree;
                    maxWindTime = result.nightWeatherMaxMin.maxWindTime;
                }
            } else if (i == 1) {
                result.morningWeatherIds = weatherIdsForPeriod;
                result.morningWeatherMaxMin = weatherMaxMinForPeriod;
                if (maxTemp < result.morningWeatherMaxMin.maxTemp) {
                    maxTemp = result.morningWeatherMaxMin.maxTemp;
                    maxTempTime = result.morningWeatherMaxMin.maxTempTime;
                }
                if (minTemp > result.morningWeatherMaxMin.minTemp) {
                    minTemp = result.morningWeatherMaxMin.minTemp;
                    minTempTime = result.morningWeatherMaxMin.minTempTime;
                }
                if (maxWind < result.morningWeatherMaxMin.maxWind) {
                    maxWind = result.morningWeatherMaxMin.maxWind;
                    windDegreeForDay = result.morningWeatherMaxMin.windDegree;
                    maxWindTime = result.morningWeatherMaxMin.maxWindTime;
                }
            } else if (i == 2) {
                result.afternoonWeatherIds = weatherIdsForPeriod;
                result.afternoonWeatherMaxMin = weatherMaxMinForPeriod;
                if (maxTemp < result.afternoonWeatherMaxMin.maxTemp) {
                    maxTemp = result.afternoonWeatherMaxMin.maxTemp;
                    maxTempTime = result.afternoonWeatherMaxMin.maxTempTime;
                }
                if (minTemp > result.afternoonWeatherMaxMin.minTemp) {
                    minTemp = result.afternoonWeatherMaxMin.minTemp;
                    minTempTime = result.afternoonWeatherMaxMin.minTempTime;
                }
                if (maxWind < result.afternoonWeatherMaxMin.maxWind) {
                    maxWind = result.afternoonWeatherMaxMin.maxWind;
                    windDegreeForDay = result.afternoonWeatherMaxMin.windDegree;
                    maxWindTime = result.afternoonWeatherMaxMin.maxWindTime;
                }
            } else {
                result.eveningWeatherIds = weatherIdsForPeriod;
                result.eveningWeatherMaxMin = weatherMaxMinForPeriod;
                if (maxTemp < result.eveningWeatherMaxMin.maxTemp) {
                    maxTemp = result.eveningWeatherMaxMin.maxTemp;
                    maxTempTime = result.eveningWeatherMaxMin.maxTempTime;
                }
                if (minTemp > result.eveningWeatherMaxMin.minTemp) {
                    minTemp = result.eveningWeatherMaxMin.minTemp;
                    minTempTime = result.eveningWeatherMaxMin.minTempTime;
                }
                if (maxWind < result.eveningWeatherMaxMin.maxWind) {
                    maxWind = result.eveningWeatherMaxMin.maxWind;
                    windDegreeForDay = result.eveningWeatherMaxMin.windDegree;
                    maxWindTime = result.eveningWeatherMaxMin.maxWindTime;
                }
                if (result.dayOfYear == null) {
                    result.dayOfYear = weatherMaxMinForPeriod.dayOfYear;
                }
            }
        }
        result.maxTempForDay = maxTemp;
        result.maxRainTime = maxRainTime;
        result.maxSnowTime = maxSnowTime;
        result.maxTempTime = maxTempTime;
        result.minTempTime = minTempTime;
        result.maxWindTime = maxWindTime;
        result.minTempForDay = minTemp;
        result.maxWindForDay = maxWind;
        result.windDegreeForDay = windDegreeForDay;
        return result;
    }

