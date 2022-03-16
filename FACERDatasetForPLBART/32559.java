    @Override
    protected void serviceConnected(ServiceConnection serviceConnection) {
        if (weatherForecastUnsentMessages.isEmpty()) {
            jobFinished(params, false);
        }
    }

