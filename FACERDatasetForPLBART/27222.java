    private void getHourlyOrmWeather(long cityId, ForecastWeather response, List<OrmWeather> ormWeatherList) throws ParseException {
        for (ForecastDay forecastDay : response.getForecast().getForecastday()) {
//            for (Hour hour : forecastDay.getHours()) {
//                if (fmt.parse(hour.getTime()).after(Calendar.getInstance().getTime())) {//no save old forecast
                    OrmWeather weather = new OrmWeather();
                    weather.setCity_id(cityId);
                    weather.setCity_name(response.getLocation().getName());
                    weather.setDt(getConvertedDate(forecastDay.getDate()));
//                    weather.setClouds(hour.getCloud());
                    weather.setHumidity(forecastDay.getDay().getHumidity());
//                    weather.setPressure(isMetric ? convertMbToMmHg(hour.getPressureMb()) : hour.getPressureIn());
                    weather.setTemp(isMetric ? forecastDay.getDay().getAvgtempC() : forecastDay.getDay().getAvgtempF());
                    weather.setTemp_min(isMetric ?forecastDay.getDay().getMintempC():forecastDay.getDay().getMintempF());
                    weather.setTemp_max(isMetric ?forecastDay.getDay().getMaxtempC():forecastDay.getDay().getMaxtempF());
                    weather.setIcon(forecastDay.getDay().getCondition().getIcon());
                    weather.setWind_speed(isMetric ? convertKphToMps(forecastDay.getDay().getMaxwindKph()) : forecastDay.getDay().getMaxwindMph());
//                    weather.setWind_dir(hour.getWindDir());
//                    weather.setRain(hour.getWillItRain());
//                    weather.setSnow(hour.getWillItSnow());
                    String localizedCondition =  fileManager.getCondition(forecastDay.getDay().getCondition().getCode(), selectedLang);
                    if (TextUtils.isEmpty(localizedCondition)) {
                        localizedCondition = forecastDay.getDay().getCondition().getText();
                    }
                    weather.setCondition_text(localizedCondition);
                    weather.setCondition_code(forecastDay.getDay().getCondition().getCode());
                    weather.setIs_day(false);
                    ormWeatherList.add(weather);
//                }
//            }
        }
    }

