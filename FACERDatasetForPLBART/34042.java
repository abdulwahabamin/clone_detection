        @Override
        protected void onPostExecute(Void aVoid) {
            Location location = locationListener.getLocation();
            if (location != null) {
                Log.d(TAG, String.format("Determined location: latitude %f - longitude %f", location.getLatitude(), location.getLongitude()));
                new GetCityNameTask().execute(String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()));
            } else {
                Log.e(TAG, "Couldn't determine location. Using last known location.");
                new GetWeatherTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
                new GetLongTermWeatherTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
            try {
                locationManager.removeUpdates(locationListener);
            } catch (SecurityException e) {
                Log.e(TAG, "Couldn't remove location updates. Probably this is an Android (>M) runtime permissions", e);
            }
        }

