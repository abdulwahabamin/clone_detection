    @Override
    public boolean onStopJob(JobParameters params) {
        getApplicationContext().unbindService(locationUpdateServiceConnection);
        unbindAllServices();
        return true;
    }

