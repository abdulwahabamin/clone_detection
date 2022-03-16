    @Override
    public boolean onStopJob(JobParameters params) {
        appendLog(getBaseContext(), TAG, "onStopJob");
        unbindAllServices();
        return true;
    }

