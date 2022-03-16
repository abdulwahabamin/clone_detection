    private void unbindLocationUpdateService(Context context) {
        if (locationUpdateService == null) {
            return;
        }
        context.getApplicationContext().unbindService(locationUpdateServiceConnection);
    }

