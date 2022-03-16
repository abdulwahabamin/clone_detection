    private void unbindLocationUpdateService() {
        if (locationUpdateService == null) {
            return;
        }
        context.unbindService(locationUpdateServiceConnection);
    }

