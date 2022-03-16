    @Override
    public boolean onUnbind(Intent intent) {
        getApplicationContext().unbindService(screenOnOffUpdateServiceConnection);
        getApplicationContext().unbindService(sensorLocationUpdateServiceConnection);
        bound = false;
        return super.onUnbind(intent);
    }

