    @Override
    protected void serviceConnected(ServiceConnection serviceConnection) {
        if (currentWeatherUnsentMessages.isEmpty()) {
            jobFinished(params, false);
        }
    }

