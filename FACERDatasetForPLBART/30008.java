    /**
     * Stop using GPS listener
     * Calling this function will stop using GPS in your app
     * */
    public void stopUsingGPS(){
        if(locationManager != null)
            try {
                locationManager.removeUpdates(GPSTracker.this);
            }
            catch (SecurityException ex) {
                ex.printStackTrace();
            }
    }

