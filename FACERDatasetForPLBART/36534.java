    /**
     * 触�?�滑动刷新�?�执行的�?作
     */
    @Override
    public void onRefresh() {
        SharedPreferences prefs = getSharedPreferences("data_setting", MODE_PRIVATE);
        String cityName = prefs.getString("nonce_city", null);
        prefs = getSharedPreferences("data_city", MODE_PRIVATE);
        final String weatherCode = prefs.getString(cityName, null);
        if (!TextUtils.isEmpty(weatherCode)) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    queryWeatherInfo(weatherCode);
                    swipe_container.setRefreshing(false);
                }
            }, 0); // 0秒�?��?��?消�?�，�?�止刷新
        } else {
            ToastUtil.showToast(WeatherActivity.this, "☜ 亲�?先添加一个城市�?�", Toast.LENGTH_SHORT);
            swipe_container.setRefreshing(false);
        }
    }

