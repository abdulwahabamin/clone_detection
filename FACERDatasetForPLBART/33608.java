    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        String jsonString = args.getString(JSON_STRING);
        Gson gson = new Gson();
        CityCurrentWeather cityCurrentWeather = gson.fromJson(jsonString, CityCurrentWeather.class);
        displayWeather(cityCurrentWeather);
    }

