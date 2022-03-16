    private void initLocation() {
        //�?始化定�?
        mLocationClient = new AMapLocationClient(getApplicationContext());
        //设置定�?回调监�?�

        //声明AMapLocationClientOption对象
        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        //设置定�?模�?为AMapLocationMode.Hight_Accuracy，高精度模�?。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定�?间隔,�?��?毫秒,默认为2000ms，最低1000ms。
        mLocationOption.setInterval(10000);
        //�?��?是毫秒，默认30000毫秒，建议超时时间�?�?低于8000毫秒。
        mLocationOption.setHttpTimeOut(20000);
        mLocationClient.setLocationListener(mLocationListener);
        //给定�?客户端对象设置定�?�?�数
        mLocationClient.setLocationOption(mLocationOption);
        //�?�动定�?
        mLocationClient.startLocation();
    }

