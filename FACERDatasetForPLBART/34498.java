    @Override
    public void pickWeather(String cityName, final Action1<WeatherBuilder> action) {
        heWeatherREST.getWeatherAsync(cityName, HeWeatherREST.API_KEY).subscribe(new Action1<ResponseBody>() {
            @Override
            public void call(ResponseBody responseBody) {
                try {
                    String body = responseBody.string();
                    //Log.d("weather", "body : " + body);
                    WeatherBuilder builder = new HeWeatherBuilder(body);
                    action.call(builder);
                } catch (IOException | JSONException e) {
                    action.call(null);
                    e.printStackTrace();
                }
            }
        });
    }

