    @Override
    public void onRequestPermissionsResult(int requestCode ,
                                           @NonNull String permissions[] ,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case Constants.READ_COARSE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    gps = new GPSTracker(getContext());
                    if (!gps.canGetLocation())
                        gps.showSettingsAlert();
                    else {
                        preferences.setLatitude(Float.parseFloat(gps.getLatitude()));
                        preferences.setLongitude(Float.parseFloat(gps.getLongitude()));
                        launchActivity(1);
                    }
                } else {
                    permission.permissionDenied();
                }
                break;
            }
        }
    }

