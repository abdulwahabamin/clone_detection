    private void bindLocationUpdateService(Context context) {
        context.getApplicationContext().bindService(
                new Intent(context.getApplicationContext(), LocationUpdateService.class),
                locationUpdateServiceConnection,
                Context.BIND_AUTO_CREATE);
    }

