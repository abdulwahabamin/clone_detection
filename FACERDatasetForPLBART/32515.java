    private void registerSensorListener() {
        appendLog(getBaseContext(), TAG, "START_SENSOR_BASED_UPDATES recieved");
        senSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        
        registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_SCREEN_OFF));
        
        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getBaseContext());
        org.thosp.yourlocalweather.model.Location autoLocation = locationsDbHelper.getLocationByOrderId(0);
        if (!autoLocation.isEnabled()) {
            return;
        }

        Notification notification = NotificationUtils.getWeatherNotification(this, autoLocation.getId());
        if (notification != null) {
            startForeground(android.os.Process.myPid(), notification);
        }

        sensorResolutionMultiplayer = 1 / senAccelerometer.getResolution();
        int maxDelay = 10000;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            maxDelay = senAccelerometer.getMaxDelay();
            appendLog(getBaseContext(),
                  TAG,
                  "Selected accelerometer sensor:",
                  senAccelerometer,
                  ", sensor's resolution:",
                  senAccelerometer.getResolution(),
                  ", sensor's max delay: ",
                  senAccelerometer.getMaxDelay());
        } else {
            appendLog(getBaseContext(),
                  TAG,
                  "Selected accelerometer sensor:",
                  senAccelerometer,
                  ", sensor's resolution:",
                  senAccelerometer.getResolution());
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            appendLog(getBaseContext(), TAG, "Result of registering (new) sensor listener: " + senSensorManager.registerListener(
                    this,
                    senAccelerometer ,
                    maxDelay,
                    maxDelay));
        } else {
            appendLog(getBaseContext(), TAG, "Result of registering sensor listener: " + senSensorManager.registerListener(
                    this,
                    senAccelerometer ,
                    maxDelay));
        }
    }

