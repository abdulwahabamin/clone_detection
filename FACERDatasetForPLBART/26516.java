    @TargetApi(Build.VERSION_CODES.M)
    public void initUrgentPermission(final BaseActivity activity) {

        final String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.WRITE_EXTERNAL_STORAGE};
        ActivityCompat.requestPermissions(activity,permissions, URGENT_PERMISSION);

        for(final String permission : permissions) {

            if((ActivityCompat.checkSelfPermission(CoreManager.getContext(), permission) != PackageManager.PERMISSION_GRANTED)){
                if(Manifest.permission.ACCESS_FINE_LOCATION.equals(permission)) {
                    CoreManager.getImpl(ILocationApi.class).startLocation();
                }else if(Manifest.permission.WRITE_EXTERNAL_STORAGE.equals(permission)){
                    CoreManager.getImpl(ICityProvider.class).loadCitys();
                }
            }
        }
    }

