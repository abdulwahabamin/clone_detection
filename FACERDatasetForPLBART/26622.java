    public void getWeatherForecastForId(Integer i){
        try {
            JSONObject jDayForecast = list.getJSONObject(i);
            date = jDayForecast.getInt("dt");
            main = jDayForecast.getJSONObject("main");
            temp = main.getInt("temp");
            weather = jDayForecast.getJSONArray("weather");
            JSONObject JSONWeather = weather.getJSONObject(0);
            description = JSONWeather.getString("description");
            weather_id = JSONWeather.getInt("id");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

