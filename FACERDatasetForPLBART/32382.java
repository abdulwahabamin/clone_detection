        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            LocationUpdateService.LocationUpdateServiceBinder binder =
                    (LocationUpdateService.LocationUpdateServiceBinder) service;
            locationUpdateService = binder.getService();
            locationUpdateService.updateNetworkLocation(
                    params.getExtras().getBoolean("byLastLocationOnly"),
                    null,
                    params.getExtras().getInt("attempts"));
            new Thread(new Runnable() {
                public void run() {
                    serviceConnected(locationUpdateServiceConnection);
                }
            }).start();
        }

