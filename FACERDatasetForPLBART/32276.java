    private void sendSensorStartIntent() {
        appendLog(getBaseContext(), TAG, "sensorLocationUpdateService.startSensorBasedUpdates");
        if (sensorLocationUpdateService == null) {
            sensorLocationUpdateServiceActions.add(BindedServiceActions.START_SENSOR);
            return;
        }
        sensorLocationUpdateService.startSensorBasedUpdates(0);
    }

