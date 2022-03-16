    @Override
    public boolean onStartJob(JobParameters params) {
        this.params = params;
        appendLog(getBaseContext(), TAG, "onStartJob");
        sendRetryMessageToCurrentWeatherService();
        return true;
    }

