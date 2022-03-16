    public static WeatherInfo parse(WeatherInfo info) {
        if (info == null || info.getCounty() == null || info.getRawJSONString() == null) {
            return null;
        }

        try {
            JSONObject object = JSON.parseObject(info.getRawJSONString());
            JSONObject infoObj = object.getJSONArray(KEY_HEWEATHER).getJSONObject(0);

            JSONObject now = infoObj.getJSONObject(KEY_NOW);
            info.setCountyWeather(now.getJSONObject(KEY_CONDITION).getString(KEY_TXT));
            info.setNowTemperature(now.getIntValue(KEY_TEMPERATURE));

            JSONArray dailyForecast = infoObj.getJSONArray(KEY_DAILY_FORECAST);

            // These codes are too silly, I know that :(
            JSONObject today = dailyForecast.getJSONObject(0);
            info.setTodayDayWeather(today.getJSONObject(KEY_CONDITION).getString(KEY_TXT_DAY));
            info.setTodayNightWeather(today.getJSONObject(KEY_CONDITION).getString(KEY_TXT_NIGHT));
            info.setTodayMaxTemperature(today.getJSONObject(KEY_TEMPERATURE).getIntValue(KEY_MAX));
            info.setTodayMinTemperature(today.getJSONObject(KEY_TEMPERATURE).getIntValue(KEY_MIN));
            info.setTodayHumidity(today.getIntValue(KEY_HUMIDITY));
            info.setTodayRainProbability(today.getIntValue(KEY_RAIN_PROBABILITY));
            info.setTodayVisibility(today.getIntValue(KEY_VISIBILITY));

            JSONObject tomorrow = dailyForecast.getJSONObject(1);
            info.setTomorrowDayWeather(tomorrow.getJSONObject(KEY_CONDITION).getString(KEY_TXT_DAY));
            info.setTomorrowMaxTemperature(tomorrow.getJSONObject(KEY_TEMPERATURE).getIntValue(KEY_MAX));
            info.setTomorrowMinTemperature(tomorrow.getJSONObject(KEY_TEMPERATURE).getIntValue(KEY_MIN));

            JSONObject dayAfterTomorrow = dailyForecast.getJSONObject(2);
            info.setDayAfterTomorrowDayWeather(dayAfterTomorrow.getJSONObject(KEY_CONDITION).getString(KEY_TXT_DAY));
            info.setDayAfterTomorrowMaxTemperature(dayAfterTomorrow.getJSONObject(KEY_TEMPERATURE).getIntValue(KEY_MAX));
            info.setDayAfterTomorrowMinTemperature(dayAfterTomorrow.getJSONObject(KEY_TEMPERATURE).getIntValue(KEY_MIN));

            return info;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

