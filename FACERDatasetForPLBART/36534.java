    /**
     * è§¦å?‘æ»‘åŠ¨åˆ·æ–°å?Žæ‰§è¡Œçš„æ“?ä½œ
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
            }, 0); // 0ç§’å?Žå?‘é€?æ¶ˆæ?¯ï¼Œå?œæ­¢åˆ·æ–°
        } else {
            ToastUtil.showToast(WeatherActivity.this, "â˜œ äº²ï¼?å…ˆæ·»åŠ ä¸€ä¸ªåŸŽå¸‚å?§", Toast.LENGTH_SHORT);
            swipe_container.setRefreshing(false);
        }
    }

