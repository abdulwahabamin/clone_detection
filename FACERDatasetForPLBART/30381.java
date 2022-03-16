        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation.getErrorCode() == 0) {
                ContentUtil.NOW_LON = aMapLocation.getLongitude();
                ContentUtil.NOW_LAT = aMapLocation.getLatitude();
                Log.i(TAG, "now location: " +  ContentUtil.NOW_LON + "," + ContentUtil.NOW_LAT);
            }else {
                String errText = "定�?失败," + aMapLocation.getErrorCode() + ": " + aMapLocation.getErrorInfo();
                Log.e(TAG, errText);
            }
        }

