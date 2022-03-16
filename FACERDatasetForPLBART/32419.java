    @Override
    public boolean onStopJob(JobParameters params) {
        if (networkLocationProvider != null) {
            getApplicationContext().unbindService(networkLocationProviderConnection);
        }
        return true;
    }

