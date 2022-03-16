    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        String jsonString = args.getString(WeatherInfoFragment.JSON_STRING);
        Gson gson = new Gson();
        CityThreeHourlyWeatherForecast threeHourlyWeatherForecast = gson.fromJson(jsonString,
                CityThreeHourlyWeatherForecast.class);
        displayWeather(threeHourlyWeatherForecast);
    }

