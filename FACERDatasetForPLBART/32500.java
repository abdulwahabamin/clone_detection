        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            LocationUpdateService.LocationUpdateServiceBinder binder =
                    (LocationUpdateService.LocationUpdateServiceBinder) service;
            locationUpdateService = binder.getService();
            LocationUpdateService.LocationUpdateServiceActions bindedServiceAction;
            while ((bindedServiceAction = locationUpdateServiceActions.poll()) != null) {
                if (locationUpdateService.updateNetworkLocation(false, null, 0)) {
                    processLocationUpdate = false;
                    gravity[0] = 0;
                    gravity[1] = 0;
                    gravity[2] = 0;
                    currentLength = 0;
                    currentLengthLowPassed = 0;
                }
            }
        }

