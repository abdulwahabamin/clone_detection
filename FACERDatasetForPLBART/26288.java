    private void fetchFollowedWeather() {
        TaskScheduler.execute(new Task<List<WeatherData>>() {
            @Override
            public List<WeatherData> doInBackground() throws InterruptedException {
                return  CoreManager.getImpl(IWeatherProvider.class).fetchFollowedWeather();
            }

            @Override
            public void onSuccess(List<WeatherData> weatherData) {
                parseFollowedWeathers(weatherData);
            }
        });

    }

