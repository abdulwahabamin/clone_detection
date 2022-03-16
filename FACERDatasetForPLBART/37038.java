    public void init(Context context) {
        mLocationClient = new AMapLocationClient(context.getApplicationContext());
        mLocationClient.setLocationListener(mLocationListener);
        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        //设置定�?模�?为AMapLocationMode.Hight_Accuracy，高精度模�?。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //获�?�一次定�?结果，该方法默认为false。
        mLocationOption.setOnceLocation(true);
        //获�?�最近3s内精度最高的一次定�?结果，设置setOnceLocationLatest(boolean b)接�?�为true，�?�动定�?时SDK会返回最近3s内精度最高的一次定�?结果。
        // 如果设置其为true，setOnceLocation(boolean b)接�?�也会被设置为true，�??之�?会，默认为false。
        mLocationOption.setOnceLocationLatest(true);
        //设置是�?�返回地�?�信�?�（默认返回地�?�信�?�）
        mLocationOption.setNeedAddress(true);
        //设置是�?��?许模拟�?置,默认为true，�?许模拟�?置
        mLocationOption.setMockEnable(false);
        //给定�?客户端对象设置定�?�?�数
        mLocationClient.setLocationOption(mLocationOption);
    }

