    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        localDataSource = ((WeatherApp) getApplicationContext()).getLocalDataSource();
        if (PreferencesHelper.getInstance().isUseCurrentLocation(this)) {
            if (savedInstanceState == null) {
                askForPermission(Manifest.permission.ACCESS_FINE_LOCATION, PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }

