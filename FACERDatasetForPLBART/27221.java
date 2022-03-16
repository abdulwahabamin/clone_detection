    private OrmWeather getCurrentOrmWeather(long cityId, ForecastWeather response ) throws ParseException {
        Current current = response.getCurrent();
        ForecastDay forecastDay = response.getForecast().getForecastday().get(0);
        OrmWeather weather = new OrmWeather();
        weather.setCity_id(cityId);
        weather.setCity_name(response.getLocation().getName());
        weather.setDt(fmt.parse(current.getLastUpdated()));
        weather.setClouds(current.getCloud());
        weather.setHumidity(current.getHumidity());
        weather.setPressure(isMetric ? convertMbToMmHg(current.getPressureMb()) : current.getPressureIn());
        weather.setTemp(isMetric?current.getTempC():current.getTempF());
        weather.setTemp_min(isMetric ?forecastDay.getDay().getMintempC():forecastDay.getDay().getMintempF());
        weather.setTemp_max(isMetric ?forecastDay.getDay().getMaxtempC():forecastDay.getDay().getMaxtempF());
        weather.setIs_day(current.getIs_day()==1);
        weather.setIcon(current.getCondition().getIcon());
        String localizedCondition =  fileManager.getCondition(current.getCondition().getCode(), selectedLang);
        if (TextUtils.isEmpty(localizedCondition)) {
            localizedCondition = current.getCondition().getText();
        }
        weather.setCondition_text(localizedCondition);
        weather.setCondition_code(current.getCondition().getCode());
        weather.setWind_speed(isMetric ? convertKphToMps(current.getWindKph()) : current.getWindMph());
        weather.setWind_dir(response.getCurrent().getWindDir());
        return weather;
    }

