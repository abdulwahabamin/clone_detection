    private void startTask() {
        temperatureChart = rootView.findViewById(R.id.temperature_chart);
        rainChart = rootView.findViewById(R.id.rain_chart);
        pressureChart = rootView.findViewById(R.id.pressure_chart);
        snowChart = rootView.findViewById(R.id.snow_chart);
        windChart = rootView.findViewById(R.id.wind_chart);
        mDescribable = (ArrayList<WeatherFort.WeatherList>) getArguments().getSerializable(DESCRIBABLE_KEY);
        function();
    }

