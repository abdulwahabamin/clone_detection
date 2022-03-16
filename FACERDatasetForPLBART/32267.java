    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(getApplicationContext(), ScreenOnOffUpdateService.class);
        getApplicationContext().bindService(intent, screenOnOffUpdateServiceConnection, Context.BIND_AUTO_CREATE);
        intent = new Intent(getApplicationContext(), SensorLocationUpdateService.class);
        getApplicationContext().bindService(intent, sensorLocationUpdateServiceConnection, Context.BIND_AUTO_CREATE);
    }

