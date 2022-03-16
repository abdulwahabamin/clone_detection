    private void detectLocation() {
        if (!PermissionUtil.checkPermissionsAndSettings(this)) {
            updateWidgets(updateSource);
            stopSelf();
            return;
        }
        boolean isNetworkEnabled = locationManager.getAllProviders().contains(LocationManager.NETWORK_PROVIDER)
                && locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        appendLog(getBaseContext(), TAG, "detectLocation:isNetworkEnabled=", isNetworkEnabled);
        if (isNetworkEnabled && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            appendLog(getBaseContext(), TAG, "detectLocation:afterCheckSelfPermission");
            startRefreshRotation("detectLocation", 3);
            final Looper locationLooper = Looper.myLooper();
            locationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, this, locationLooper);
            final LocationListener locationListener = this;
            final Handler locationHandler = new Handler(locationLooper);
            locationHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    locationManager.removeUpdates(locationListener);
                    appendLog(getBaseContext(), TAG, "detectLocation:lastLocationUpdateTime=", lastLocationUpdateTime);
                    if ((System.currentTimeMillis() - (2 * LOCATION_TIMEOUT_IN_MS)) < lastLocationUpdateTime) {
                        return;
                    }
                    LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(getBaseContext());
                    org.thosp.yourlocalweather.model.Location currentLocation = locationsDbHelper.getLocationByOrderId(0);
                    locationsDbHelper.updateLocationSource(currentLocation.getId(), getString(R.string.location_weather_update_status_update_started));
                    if (ContextCompat.checkSelfPermission(LocationUpdateService.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        Location lastNetworkLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        Location lastGpsLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        if ((lastGpsLocation == null) && (lastNetworkLocation != null)) {
                            locationsDbHelper.updateLocationSource(currentLocation.getId(), getString(R.string.location_weather_update_status_location_from_network));
                            locationListener.onLocationChanged(lastNetworkLocation);
                        } else if ((lastGpsLocation != null) && (lastNetworkLocation == null)) {
                            locationsDbHelper.updateLocationSource(currentLocation.getId(), getString(R.string.location_weather_update_status_location_from_gps));
                            locationListener.onLocationChanged(lastGpsLocation);
                        } else if (AppPreference.isGpsEnabledByPreferences(getBaseContext())){
                            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                            new CountDownTimer(30000, 10000) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                }

                                @Override
                                public void onFinish() {
                                    locationManager.removeUpdates(LocationUpdateService.this);
                                    stopSelf();
                                }
                            }.start();
                        }
                    }
                    appendLog(getBaseContext(), TAG, "detectLocation:requestWeatherCheck");
                    requestWeatherCheck(currentLocation.getId(), updateSource, AppWakeUpManager.SOURCE_CURRENT_WEATHER, forceUpdate);
                }
            }, LOCATION_TIMEOUT_IN_MS);
        }
    }

