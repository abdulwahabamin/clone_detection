    public void scanNew(View v)
    {
        permissionHelper.requestPermission(
                new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION},200);
    }

