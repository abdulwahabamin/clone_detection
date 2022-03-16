    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        ++mLocationCounter;

        if (null == aMapLocation || TextUtils.isEmpty(aMapLocation.getCountry()) || TextUtils.isEmpty(aMapLocation.getProvince())
                || TextUtils.isEmpty(aMapLocation.getCity())) {
            if (mLocationCounter > LOCATION_UPPER_BOUND) {
                //mView.showError("å®šä½?å¤±è´¥");
                mIsLocateSucceeded = false;
                mLocationClient.stopLocation();
                mIsLocateFinished = true;
                gotoNext();
            }
            return;
        }

        mLocationEntity = new LocationEntity();
        mLocationEntity.setCountry(aMapLocation.getCountry());
        mLocationEntity.setProvince(aMapLocation.getProvince());
        mLocationEntity.setCity(aMapLocation.getCity());
        mLocationEntity.setCityCode(aMapLocation.getCityCode());
        mLocationEntity.setDistrict(aMapLocation.getDistrict());
        //mView.showError("å®šä½?æˆ?åŠŸ");
        mIsLocateSucceeded = true;
        mLocationClient.stopLocation();
        mIsLocateFinished = true;

        gotoNext();
    }

