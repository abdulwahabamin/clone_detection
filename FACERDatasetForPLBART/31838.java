    public boolean checkPermissionsSettingsAndShowAlert() {
        if (permissionsAndSettingsRequested) {
            return true;
        }
        permissionsAndSettingsRequested = true;
        Location autoUpdateLocation = locationsDbHelper.getLocationByOrderId(0);
        if (!autoUpdateLocation.isEnabled()) {
            return true;
        }
        AlertDialog.Builder settingsAlert = new AlertDialog.Builder(MainActivity.this);
        settingsAlert.setTitle(R.string.alertDialog_location_permission_title);

        LocationManager locationManager = (LocationManager) getBaseContext().getSystemService(Context.LOCATION_SERVICE);
        boolean isGPSEnabled = locationManager.getAllProviders().contains(LocationManager.GPS_PROVIDER)
                && locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetworkEnabled = locationManager.getAllProviders().contains(LocationManager.NETWORK_PROVIDER)
                && locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        String geocoder = AppPreference.getLocationGeocoderSource(getBaseContext());

        boolean gpsNotEnabled = !isGPSEnabled && AppPreference.isGpsEnabledByPreferences(getBaseContext());
        boolean networkNotEnabled = !isNetworkEnabled && "location_geocoder_system".equals(geocoder);

        if (gpsNotEnabled || networkNotEnabled) {
            settingsAlert.setMessage(R.string.alertDialog_location_permission_message_location_phone_settings);
            settingsAlert.setPositiveButton(R.string.alertDialog_location_permission_positiveButton_settings,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            permissionsAndSettingsRequested = false;
                            Intent goToSettings = new Intent(
                                    Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(goToSettings);
                        }
                    });
        } else {
            List<String> permissions = new ArrayList<>();
            StringBuilder notificationMessage = new StringBuilder();
            if (AppPreference.isGpsEnabledByPreferences(getBaseContext()) &&
                    isGPSEnabled &&
                    ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                notificationMessage.append(getString(R.string.alertDialog_location_permission_message_location_phone_settings) + "\n\n");
                permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            }
            if ("location_geocoder_local".equals(geocoder) && ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                notificationMessage.append(getString(R.string.alertDialog_location_permission_message_location_phone_permission));
                permissions.add(Manifest.permission.READ_PHONE_STATE);
            } else if (isNetworkEnabled && "location_geocoder_system".equals(geocoder) && ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                notificationMessage.append(getString(R.string.alertDialog_location_permission_message_location_network_permission));
                permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
            }
            if (permissions.isEmpty()) {
                return true;
            }
            settingsAlert.setMessage(notificationMessage.toString());
            final String[] permissionsArray = permissions.toArray(new String[permissions.size()]);
            final Activity mainActivity = this;
            settingsAlert.setPositiveButton(R.string.alertDialog_location_permission_positiveButton_permissions,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(mainActivity,
                                    permissionsArray,
                                    123);
                        }
                    });
        }

        settingsAlert.setNegativeButton(R.string.alertDialog_location_permission_negativeButton,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        permissionsAndSettingsRequested = false;
                        dialog.cancel();
                    }
                });
        settingsAlert.show();
        return false;
    }

