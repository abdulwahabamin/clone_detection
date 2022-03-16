    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_EXTERNAL_STORAGE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Load data
                initialSetup(null);

            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    AlertDialogHelper alertDialogHelper = new AlertDialogHelper(MainActivity.this);
                    alertDialogHelper.displayAlertDialog("This permission is important to Display Storage content",
                            "Important permission required", "OK", "Deny",
                            new AlertDialogCallback() {
                                @Override
                                public void alertDialogPositiveButtonClicked(Object obj) {
                                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_EXTERNAL_STORAGE);
                                }

                                @Override
                                public void alertDialogNegativeButtonClicked(String message) {
                                    MainActivity.this.finish();
                                }
                            });
                    //ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_EXTERNAL_STORAGE);
                }
            }
        }
    }

