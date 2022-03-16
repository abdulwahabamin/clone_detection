    @Override
    public boolean onStopJob(JobParameters params) {
        if (screenOnOffUpdateService != null) {
            getApplicationContext().unbindService(screenOnOffUpdateServiceConnection);
        }
        if (locationUpdateService != null) {
            getApplicationContext().unbindService(locationUpdateServiceConnection);
        }
        appendLog(this, TAG, "unbinding sensorLocationUpdate: ",
                sensorLocationUpdateServiceConnection);
        if (sensorLocationUpdateServiceConnection !=null) {
            try {
                getApplicationContext().unbindService(sensorLocationUpdateServiceConnection);
            } catch (Exception e) {
                appendLog(this, TAG, e.getMessage(), e);
            }
        }
        unbindAllServices();
        return true;
    }

