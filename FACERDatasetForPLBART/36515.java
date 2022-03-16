    /**
     * 为按键注册监�?�事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
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
                break;
            default:
                break;
        }
    }

