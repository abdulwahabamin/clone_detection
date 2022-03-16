    private void sendScreenStartIntent() {
        appendLog(getBaseContext(), TAG, "screenOnOffUpdateService.startSensorBasedUpdates");
        if (screenOnOffUpdateService == null) {
            screenOnOffUpdateServiceActions.add(BindedServiceActions.START_SCREEN);
            return;
        }
        screenOnOffUpdateService.startSensorBasedUpdates();
    }

