    /**
     * �?�获Back按键，根�?�当�?的级别判断，此时应该返回市列表�?�?列表�?还是直接退出
     */
    @Override
    public void onBackPressed() {
        if (currentLevel == LEVEL_COUNTY) {
            queryCities();
        } else if (currentLevel == LEVEL_CITY) {
            queryProvinces();
        } else {
            isFromWeatherActivity = getIntent().getBooleanExtra("from_weather_activity", false);
            if (isFromWeatherActivity) {
                Intent intent = new Intent(this, WeatherActivity.class);
                startActivity(intent);
            }
            finish();
        }
    }

