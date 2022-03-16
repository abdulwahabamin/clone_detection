        public void onServiceConnected(ComponentName className, IBinder service) {

            LocationUpdateService.LocationUpdateServiceBinder binder =
                    (LocationUpdateService.LocationUpdateServiceBinder) service;
            locationUpdateService = binder.getService();
            LocationUpdateService.LocationUpdateServiceActions bindedServiceAction;
            while ((bindedServiceAction = locationUpdateServiceActions.poll()) != null) {
                switch (bindedServiceAction) {
                    case START_LOCATION_AND_WEATHER_UPDATE:
                        locationUpdateService.startLocationAndWeatherUpdate(true);
                        break;
                }
            }
        }

