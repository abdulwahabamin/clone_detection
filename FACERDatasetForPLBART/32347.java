    @Override
    public boolean onUnbind(Intent intent) {
        if (networkLocationProvider != null) {
            getApplicationContext().unbindService(networkLocationProviderConnection);
        }
        return false;
    }

