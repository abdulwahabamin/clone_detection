    private void bindLocationUpdateService() {
        getApplicationContext().bindService(
            new Intent(getApplicationContext(), LocationUpdateService.class),
                locationUpdateServiceConnection,
                Context.BIND_AUTO_CREATE);
    }

