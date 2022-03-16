        @Override
        protected void onPreExecute() {
            Log.d(TAG, "Trying to determine location...");
            locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            locationListener = new BackgroundLocationListener();
            try {
                if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    // Only uses 'network' location, as asking the GPS every time would drain too much battery
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                } else {
                    Log.d(TAG, "'Network' location is not enabled. Cancelling determining location.");
                    onPostExecute(null);
                }
            } catch (SecurityException e) {
                Log.e(TAG, "Couldn't request location updates. Probably this is an Android (>M) runtime permissions issue ", e);
            }
        }

