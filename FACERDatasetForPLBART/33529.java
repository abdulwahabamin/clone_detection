    @Override
    protected void onStart() {
        super.onStart();
        if (isDualPane) {
            workerFragment.retrieveLastRequestedWeatherInfo();
        }
    }

