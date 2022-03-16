    @Override
    public boolean onStartJob(JobParameters params) {
        this.params = params;
        connectedServicesCounter = 0;
        appendLog(this, TAG, "starting cells only location lookup");
        if (locationUpdateService == null) {
            try {
                Intent intent = new Intent(getApplicationContext(), LocationUpdateService.class);
                getApplicationContext().bindService(intent, locationUpdateServiceConnection, Context.BIND_AUTO_CREATE);
            } catch (Exception ie) {
                appendLog(getBaseContext(), TAG, "currentWeatherServiceIsNotBound interrupted:", ie);
            }
        } else {
            locationUpdateService.updateNetworkLocation(
                params.getExtras().getBoolean("byLastLocationOnly"),
                null,
                params.getExtras().getInt("attempts"));
            jobFinished(params, false);
        }
        return true;
    }

