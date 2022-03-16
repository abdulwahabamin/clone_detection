    private void initLocation() {

        mLocationClient = new AMapLocationClient(CoreManager.getContext());
        AMapLocationClientOption option = new AMapLocationClientOption();
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        option.setOnceLocationLatest(true);
        mLocationClient.setLocationOption(option);
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(final AMapLocation aMapLocation) {
                LogHelper.info(TAG, "onLocationChanged %s", aMapLocation);
                if (aMapLocation != null) {

                    CoreManager.getImpl(ICityProvider.class).getCityWorkHandler().post(new Runnable() {
                        @Override
                        public void run() {
                            boolean locationSucceed = false;
                            try {
                                String city = aMapLocation.getCity().substring(0,2);
                                String district = aMapLocation.getDistrict().substring(0, 2);

                                mLocatedCity = CoreManager.getImpl(ICityProvider.class).searchCity(city,district);

                                //åŸŽå¸‚åº“å…¨å??ä¸?åŒ¹é…?
                                if (mLocatedCity == null) {
                                    city = city.substring(0,2);
                                    district = district.substring(0,2);
                                    mLocatedCity = CoreManager.getImpl(ICityProvider.class).searchCity(city,district);

                                }

                                locationSucceed = mLocatedCity != null;

                                if(locationSucceed) {
                                    mLocatedCity.latitude = String.valueOf(aMapLocation.getLatitude());
                                    mLocatedCity.longitude = String.valueOf(aMapLocation.getLongitude());
                                }
                            }catch (Exception e) {
                                LogHelper.error(TAG,"location error %s",e);
                            }

                            Router.instance().getReceiver(LocationNotification.class)
                                    .onLocation(locationSucceed, locationSucceed ?mLocatedCity.cityId:"");

                            LogHelper.info(TAG,"located city %s",mLocatedCity);


                        }
                    });

                }
            }
        });
    }

