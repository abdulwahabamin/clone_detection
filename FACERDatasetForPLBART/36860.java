    public static WeatherInfo fetch(County county) {
        // Will block the thread
        String jsonString = HttpUtils.getSync(String.format(Consts.API_WEATHER_INFO, county.getCode()));
        if (jsonString == null) {
            return null;
        }

        WeatherInfo info = new WeatherInfo();
        info.setCounty(county);
        info.setUpdateTimestamp(System.currentTimeMillis());
        info.setRawJSONString(jsonString);
        return parse(info);
    }

