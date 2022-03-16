        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            LocationUpdateService.LocationUpdateServiceBinder binder =
                    (LocationUpdateService.LocationUpdateServiceBinder) service;
            locationUpdateService = binder.getService();
            LocationAndAddressToUpdate bindedServiceAction;
            while ((bindedServiceAction = locationUpdateServiceActions.poll()) != null) {
                if (bindedServiceAction.isCanceled()) {
                    locationUpdateService.onLocationChangedCanceled();
                } else {
                    locationUpdateService.onLocationChanged(
                            bindedServiceAction.getLocation(),
                            bindedServiceAction.getAddress());
                }
            }
        }

