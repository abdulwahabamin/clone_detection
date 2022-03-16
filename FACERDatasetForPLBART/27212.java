    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            Location location = intent.getParcelableExtra(LOCATION_DATA_EXTRA);
            LocationEvent locationEvent = parseLocation(location);
            EventBus.getDefault().postSticky(locationEvent);
        }
    }

