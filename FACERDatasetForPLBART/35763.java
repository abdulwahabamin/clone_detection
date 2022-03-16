    @Override
    public List<WeatherForecast> getWeatherForecasts() {

        List<WeatherForecast> weatherForecasts = new ArrayList<>();
        MiForecast miForecast = miWeather.getForecast();

        //TODO Forecast中的日期和星期还需�?修改
        String[] weathers1 = splitWeather(miForecast.getWeather1());
        int[] temps1 = splitTemperature(miForecast.getTemp1());
        weatherForecasts.add(new WeatherForecast(miForecast.getCityId(), miForecast.getWeather1(), weathers1[0],
                weathers1[1], temps1[0], temps1[1], miForecast.getWind1(), miForecast.getDate(), DateConvertUtils.convertDataToWeek(miForecast.getDate())));

        String[] weathers2 = splitWeather(miForecast.getWeather2());
        int[] temps2 = splitTemperature(miForecast.getTemp2());
        weatherForecasts.add(new WeatherForecast(miForecast.getCityId(), miForecast.getWeather2(), weathers2[0],
                weathers2[1], temps2[0], temps2[1], miForecast.getWind2(), miForecast.getDate(), DateConvertUtils.convertDataToWeek(miForecast.getDate())));

        String[] weathers3 = splitWeather(miForecast.getWeather3());
        int[] temps3 = splitTemperature(miForecast.getTemp3());
        weatherForecasts.add(new WeatherForecast(miForecast.getCityId(), miForecast.getWeather3(), weathers3[0],
                weathers3[1], temps3[0], temps3[1], miForecast.getWind3(), miForecast.getDate(), DateConvertUtils.convertDataToWeek(miForecast.getDate())));

        String[] weathers4 = splitWeather(miForecast.getWeather4());
        int[] temps4 = splitTemperature(miForecast.getTemp4());
        weatherForecasts.add(new WeatherForecast(miForecast.getCityId(), miForecast.getWeather4(), weathers4[0],
                weathers4[1], temps4[0], temps4[1], miForecast.getWind4(), miForecast.getDate(), DateConvertUtils.convertDataToWeek(miForecast.getDate())));

        String[] weathers5 = splitWeather(miForecast.getWeather5());
        int[] temps5 = splitTemperature(miForecast.getTemp5());
        weatherForecasts.add(new WeatherForecast(miForecast.getCityId(), miForecast.getWeather5(), weathers5[0],
                weathers5[1], temps5[0], temps5[1], miForecast.getWind5(), miForecast.getDate(), DateConvertUtils.convertDataToWeek(miForecast.getDate())));

        String[] weathers6 = splitWeather(miForecast.getWeather6());
        int[] temps6 = splitTemperature(miForecast.getTemp6());
        weatherForecasts.add(new WeatherForecast(miForecast.getCityId(), miForecast.getWeather6(), weathers6[0],
                weathers6[1], temps6[0], temps6[1], miForecast.getWind6(), miForecast.getDate(), DateConvertUtils.convertDataToWeek(miForecast.getDate())));

        return weatherForecasts;
    }

