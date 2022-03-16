    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//�?�选，默认高精度，设置定�?模�?，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//�?�选，默认gcj02，设置返回的定�?结果�??标系
        option.setScanSpan(1000);//�?�选，默认0，�?�仅定�?一次，设置�?�起定�?请求的间隔需�?大于等于1000ms�?是有效的
        option.setIsNeedAddress(true);//�?�选，设置是�?�需�?地�?�信�?�，默认�?需�?
        option.setOpenGps(true);//�?�选，默认false,设置是�?�使用gps
        option.setLocationNotify(true);//�?�选，默认false，设置是�?�当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//�?�选，默认false，设置是�?�需�?�?置语义化结果，�?�以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近�?
        option.setIsNeedLocationPoiList(true);//�?�选，默认false，设置是�?�需�?POI结果，�?�以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//�?�选，默认true，定�?SDK内部是一个SERVICE，并放到了独立进程，设置是�?�在stop的时候�?�死这个进程，默认�?�?�死
        option.SetIgnoreCacheException(false);//�?�选，默认false，设置是�?�收集CRASH信�?�，默认收集
        option.setEnableSimulateGps(false);//�?�选，默认false，设置是�?�需�?过滤GPS仿真结果，默认需�?
        MyApplication.getmLocationClient().setLocOption(option);
    }

