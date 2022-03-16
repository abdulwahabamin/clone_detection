    private void performUpdateOfLocation() {
        try {
            Intent intent = new Intent(getApplicationContext(), SensorLocationUpdateService.class);
            getApplicationContext().bindService(intent, sensorLocationUpdateServiceConnection, Context.BIND_AUTO_CREATE);
        } catch (Exception ie) {
            appendLog(getBaseContext(), TAG, "currentWeatherServiceIsNotBound interrupted:", ie);
        }
    }

