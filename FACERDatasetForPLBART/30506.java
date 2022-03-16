    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_LOCATION:
                startService(new Intent(this, LocationService.class));
                startIntent();
                break;
            default:
                startIntent();
                break;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

