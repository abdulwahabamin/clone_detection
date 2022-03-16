    @Override
    public boolean onStartJob(JobParameters params) {
        this.params = params;
        appendLog(this, TAG, "starting cells only location lookup");
        Intent intent = new Intent(getApplicationContext(), NetworkLocationProvider.class);
        try {
            getApplicationContext().bindService(intent, networkLocationProviderConnection, Context.BIND_AUTO_CREATE);
        } catch (Exception ie) {
            appendLog(getBaseContext(), TAG, "currentWeatherServiceIsNotBound interrupted:", ie);
        }
        return true;
    }

