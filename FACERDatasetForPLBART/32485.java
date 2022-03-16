    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        try {
            Sensor mySensor = sensorEvent.sensor;

            if (mySensor.getType() != Sensor.TYPE_ACCELEROMETER) {
                return;
            }
            processSensorEvent(sensorEvent);
        } catch (Exception e) {
            appendLog(getBaseContext(), TAG, "Exception on onSensorChanged", e);
        }
    }

