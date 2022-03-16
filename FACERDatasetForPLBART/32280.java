    private void sendSensorAndScreenStopIntent() {
        appendLog(getBaseContext(), TAG, "sendSensorAndScreenStopIntent");
        if (screenOnOffUpdateService == null) {
            screenOnOffUpdateServiceActions.add(BindedServiceActions.STOP_SCREEN);
        } else {
            screenOnOffUpdateService.stopSensorBasedUpdates();
        }
        if (sensorLocationUpdateService == null) {
            sensorLocationUpdateServiceActions.add(BindedServiceActions.STOP_SENSOR);
        } else {
            sensorLocationUpdateService.stopSensorBasedUpdates();
        }
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(getPendingSensorStartIntent(getBaseContext()));
        alarmManager.cancel(getPendingScreenStartIntent(getBaseContext()));
    }

