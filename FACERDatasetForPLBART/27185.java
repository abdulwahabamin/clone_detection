    private void makeView(List<OrmWeather> forecasts) {
        Utility.sortWeatherHour(forecasts);
        if (forecasts.size() > 0) {
            OrmWeather current = forecasts.get(0);//current weather
            setTemp(current.getTemp());
            setHumidity(current.getHumidity());
            setWindSpeed(current.getWind_speed(), current.getWind_dir());
            if (current.getPressure()!=null && current.getPressure() > 0){
                setPressure(current.getPressure());
            }
            setCondition(current.getCondition_text());
            setDate(current.getDt());
            setImage(Utility.getImageWithForecast(current.getCondition_code(),current.getIs_day()));
            addDaysToViewPager(forecasts);
        } else {
            showError();
        }
    }

