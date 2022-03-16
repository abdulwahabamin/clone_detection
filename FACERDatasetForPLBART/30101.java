    private void getWeather() {
        Log.d("Alarm", "Recurring alarm; requesting download service.");
        if (isNetworkAvailable()) {
            new GetWeatherTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }
    }

