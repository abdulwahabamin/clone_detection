    @Override
    public void onRequestPermissionsResult(BaseActivity activity,int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if(activity.isFinishing() || activity.isDestroyed()) {
           return;
        }

        LogHelper.info(TAG,"onRequestPermissionsResult %s,%s,%s",requestCode,permissions.length,grantResults.length);

        if (requestCode == URGENT_PERMISSION ) {

            for (int index = 0; index < permissions.length;index ++ ) {

                if(Manifest.permission.ACCESS_FINE_LOCATION .equals(permissions[index]) && grantResults[index] == PackageManager.PERMISSION_GRANTED) {
                    CoreManager.getImpl(ILocationApi.class).startLocation();
                }else if(Manifest.permission.WRITE_EXTERNAL_STORAGE .equals(permissions[index]) && grantResults[index] == PackageManager.PERMISSION_GRANTED){
                    CoreManager.getImpl(ICityProvider.class).loadCitys();
                }
            }
        }
    }

