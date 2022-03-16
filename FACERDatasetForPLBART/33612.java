    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        String jsonString = args.getString(JSON_STRING);
        Gson gson = new Gson();
        CityDailyWeatherForecast cityWeatherForecast = gson.fromJson(jsonString,
                CityDailyWeatherForecast.class);
        displayWeather(cityWeatherForecast);
    }

