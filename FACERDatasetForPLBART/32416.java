        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            ScreenOnOffUpdateService.ScreenOnOffUpdateServiceBinder binder =
                    (ScreenOnOffUpdateService.ScreenOnOffUpdateServiceBinder) service;
            screenOnOffUpdateService = binder.getService();
            String bindedServiceActions;
            while ((bindedServiceActions = screenOnOffUpdateServiceActions.poll()) != null) {
                screenOnOffUpdateService.checkAndUpdateWeather();
            }
        }

