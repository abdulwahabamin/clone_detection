        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation.getErrorCode() == 0) {
                ContentUtil.NOW_LON = aMapLocation.getLongitude();
                ContentUtil.NOW_LAT = aMapLocation.getLatitude();
                getNowCity(true);
                mLocationClient.onDestroy();
            } else {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE)
                        != PackageManager.PERMISSION_GRANTED) {
                    // æ²¡æœ‰æ?ƒé™?
                    View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.pop_loc_list, null);
                    LocListWindow locListWindow = new LocListWindow(view, MATCH_PARENT, MATCH_PARENT, MainActivity.this);
                    locListWindow.show();
                    locListWindow.showAtLocation(tvLocation, Gravity.CENTER, 0, 0);
                    if (ContentUtil.FIRST_OPEN) {
                        ContentUtil.FIRST_OPEN = false;
                        SpUtils.putBoolean(MainActivity.this, "first_open", false);
                    }
                }
                getNowCity(true);
                mLocationClient.onDestroy();
            }
        }

