    private void preloadUVIndex() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        String lastUVIToday = sp.getString("lastToday", "");
        if (!lastUVIToday.isEmpty()) {
            double latitude = todayWeather.getLat();
            double longitude = todayWeather.getLon();
            if (latitude == 0 && longitude == 0) {
                return;
            }
            new TodayUVITask(this, this, progressDialog).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "coords", Double.toString(latitude), Double.toString(longitude));
        }
    }

