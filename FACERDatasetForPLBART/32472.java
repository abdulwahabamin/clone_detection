    public void stopSensorBasedUpdates() {
        appendLog(getBaseContext(), TAG, "STOP_SENSOR_BASED_UPDATES recieved");
        try {
            getApplication().unregisterReceiver(screenOnReceiver);
            getApplication().unregisterReceiver(screenOffReceiver);
            getApplication().unregisterReceiver(userUnlockedReceiver);
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                getApplicationContext().unregisterReceiver(networkConnectivityReceiver);
            } else {
                ConnectivityManager connectivityManager
                        = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

                connectivityManager.unregisterNetworkCallback(networkConnectionReceiver);
            }
        } catch (Exception e) {
            appendLog(getBaseContext(), TAG, "Error unregistering screen receivers - receivers was not registered");
        }
    }

