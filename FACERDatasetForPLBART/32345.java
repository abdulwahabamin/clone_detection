    @Override
    public void onCreate() {
        super.onCreate();
        Intent intent = new Intent(getApplicationContext(), NetworkLocationProvider.class);
        getApplicationContext().bindService(intent, networkLocationProviderConnection, Context.BIND_AUTO_CREATE);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    }

