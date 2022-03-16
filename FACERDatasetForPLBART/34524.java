    @Override
    public WeatherData build() {
        WeatherData data = new WeatherData();
        data.city = basic.city;
        data.cityId = basic.id;
        data.cnty = basic.cnty;
        data.date = basic.update[0];
        data.cond = now.cond;
        data.hum = now.hum + WeatherConstant.HUM_UNIT;
        data.fl = now.fl + WeatherConstant.CELSIUS_DEGRESS;
        data.wind = now.wind[1] + " " + now.wind[3] + WeatherConstant.WIND_UNIT;
        data.pres = now.pres + WeatherConstant.PRES_UNIT;
        if (aqi != null) {
            data.aqi = aqi.aqi;
        }
        data.dailyForecasts = dailyForecasts;
        data.hourlyForecasts = hourlyForecasts;
        data.suggestion = suggestion;
        return data;
    }

