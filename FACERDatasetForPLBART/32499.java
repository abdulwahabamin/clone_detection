    private void unbindLocationUpdateService() {
        if (locationUpdateService == null) {
            return;
        }
        getBaseContext().getApplicationContext().unbindService(locationUpdateServiceConnection);
    }

