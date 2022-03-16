    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case STORAGE_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(HomeScreenActivity.this, "Storage permissions required for proper functioning of the app", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(HomeScreenActivity.this, "Storage Permissions granted", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

