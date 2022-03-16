    private void initLocation() {
        mLocationClient = new AMapLocationClient(mView.getContext().getApplicationContext());
        mLocationClientOption = new AMapLocationClientOption();
        //设置定�?模�?为高精度模�?，Battery_Saving为低功耗模�?，Device_Sensors是仅设备模�?
        mLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置是�?�返回地�?�信�?�（默认返回地�?�信�?�）
        mLocationClientOption.setNeedAddress(true);
        //设置是�?��?�定�?一次,默认为false
        mLocationClientOption.setOnceLocation(false);
        //设置是�?�强制刷新WIFI，默认为强制刷新
        mLocationClientOption.setWifiActiveScan(true);
        //设置是�?��?许模拟�?置,默认为false，�?�?许模拟�?置
        mLocationClientOption.setMockEnable(true);
        //设置定�?间隔,�?��?毫秒,默认为2000ms
        mLocationClientOption.setInterval(1000);
        mLocationClient.setLocationOption(mLocationClientOption);
        mLocationClient.setLocationListener(this);
    }

