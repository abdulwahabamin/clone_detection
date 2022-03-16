    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(PermissionActivity.this, permission) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(PermissionActivity.this, permission)) {
                ActivityCompat.requestPermissions(PermissionActivity.this, new String[]{permission}, requestCode);
            } else {
                ActivityCompat.requestPermissions(PermissionActivity.this, new String[]{permission}, requestCode);
            }
         } else {
            if (requestCode == PERMISSIONS_REQUEST_LOCATION) {
                buildGoogleApiClient();
            }
            if (BuildConfig.DEBUG){
                Log.d(LOG_TAG, "" + permission + " is already granted.");
            }
         }
    }

