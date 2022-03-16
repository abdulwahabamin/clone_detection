    @Override
    public boolean onStartJob(JobParameters params) {
        this.params = params;
        connectedServicesCounter = 0;
        appendLog(this, TAG, "onStartJob");
        try {
            Intent intent = new Intent(getApplicationContext(), LocationUpdateService.class);
            getApplicationContext().bindService(intent, locationUpdateServiceConnection, Context.BIND_AUTO_CREATE);
            intent = new Intent(getApplicationContext(), ScreenOnOffUpdateService.class);
            getApplicationContext().bindService(intent, screenOnOffUpdateServiceConnection, Context.BIND_AUTO_CREATE);
        } catch (Exception ie) {
            appendLog(getBaseContext(), TAG, "currentWeatherServiceIsNotBound interrupted:", ie);
        }
        return true;
    }

