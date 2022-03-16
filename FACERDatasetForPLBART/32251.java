        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            LocationUpdateService.LocationUpdateServiceBinder binder =
                    (LocationUpdateService.LocationUpdateServiceBinder) service;
            locationUpdateService = binder.getService();
            LocationUpdateServiceActionsWithParams bindedServiceAction;
            while ((bindedServiceAction = locationUpdateServiceActions.poll()) != null) {
                switch (bindedServiceAction.getLocationUpdateServiceAction()) {
                    case START_LOCATION_AND_WEATHER_UPDATE:
                        locationUpdateService.startLocationAndWeatherUpdate(false);
                        break;
                    case START_LOCATION_ONLY_UPDATE:
                        locationUpdateService.updateNetworkLocation(
                                bindedServiceAction.isByLastLocationOnly(),
                                null,
                                0);
                        break;
                    case LOCATION_UPDATE:
                        locationUpdateService.onLocationChanged(
                                bindedServiceAction.getInputLocation(),
                                bindedServiceAction.getAddress());
                        break;
                }
            }
        }

