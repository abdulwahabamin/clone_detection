    private void getWeather() {
        Log.d("Alarm", "Recurring alarm; requesting download service.");
        boolean failed;
        if (isNetworkAvailable()) {
            failed = false;
            if (isUpdateLocation()) {
                new GetLocationAndWeatherTask().execute(); // This method calls the two methods below once it has determined a location
            } else {
                new GetWeatherTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                new GetLongTermWeatherTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        } else {
            failed = true;
        }
        SharedPreferences.Editor editor =
                PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean("backgroundRefreshFailed", failed);
        editor.apply();
    }

