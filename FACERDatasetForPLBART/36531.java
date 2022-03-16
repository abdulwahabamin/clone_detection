    /**
     * 根�?�传入的地�?�和类型去�?��?务器查询天气代�?�或者天气信�?�
     *
     * @author �?�?宇 2016-7-29 下�?�2:31:40
     */
    private void queryFromServer(final String address, final String type, final String weatherCode) {
        showProgressDialog();
        HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {

            @Override
            public void onFinish(String response) {
                if ("countyCode".equals(type)) {
                    if (!TextUtils.isEmpty(response)) {
                        // 从�?务器返回的数�?�中解�?出天气代�?�
                        String[] array = response.split("\\|");
                        if (array != null && array.length == 2) {
                            String weatherCode = array[1];
                            queryWeatherInfo(weatherCode);
                        }
                    }
                } else if ("weatherCode".equals(type)) {
                    // 处�?��?务器返回的天气信�?�
                    final String city = Utility.handleWeatherResponse(WeatherActivity.this, response);
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            // 将得到的城市�??与城市天气代�?�对应存储起�?�，刷新天气的时候会用到
                            SharedPreferences.Editor editor = getSharedPreferences("data_city", MODE_PRIVATE).edit();
                            editor.putString(city, weatherCode);
                            editor.commit();
                            // 更新城市列表并展示
                            updateCityList(city, "add");
                            closeProgressDialog();
                            ToastUtil.showToast(WeatherActivity.this, "天气已是最新  \\(^o^)/~", Toast.LENGTH_SHORT);

                        }
                    });
                }
            }

            @Override
            public void onError(Exception e) {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        closeProgressDialog();
                        ToastUtil.showToast(WeatherActivity.this, "Duang~ 没网了", Toast.LENGTH_SHORT);
                    }
                });
            }
        });
    }

