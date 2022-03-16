    /**
     * 获�?�天气
     * <p/>
     * 先检测喜欢城市的数�?�库是�?�为空，是的�?，添加默认城市�?都。
     * 查询天气数�?�库，必�?时进行网络请求
     */
    private void getWeatherData() {
        final List<LoveCityEntity> loveCities = mCityRepository.getAllLoveCities();
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < loveCities.size(); i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        mWeatherRepository.updateCityWeather(loveCities.get(index).getCityName());
                    } catch (Exception e) {
                        Logger.e(e,"问题");
                        MainThreadAction.getInstance().post(new Runnable() {
                            @Override
                            public void run() {
                                MyToast.createMyToast().showToast(getApplicationContext(),"网络出错");
//                                Toast.makeText(BackGroundService.this,"网络错误",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            });
        }
    }

