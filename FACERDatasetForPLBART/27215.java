    @Override
    public boolean onStartJob(JobParameters job) {
        if (BuildConfig.DEBUG) Log.d(LOG_TAG, "onStartJob " + job.getTag());
        Intent intent = new Intent(this, WeatherService.class);
        startService(intent);
        return false;
    }

