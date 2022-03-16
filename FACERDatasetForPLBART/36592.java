    /**
     * 更新天气信�?�
     */
    private void updateWeather() {
        SharedPreferences prefs = getSharedPreferences("data_city", MODE_PRIVATE);
        @SuppressWarnings("unchecked") HashMap<String, String> temp = (HashMap<String, String>) prefs.getAll();
        Collection<String> temp_1 = temp.values();
        Object[] weatherCodes = temp_1.toArray();
        for (int i = 0; i < weatherCodes.length; i++) {
            final String weatherCode = weatherCodes[i].toString();
            String address = "http://wthrcdn.etouch.cn/weather_mini?citykey=" + weatherCode;

            HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {

                @Override
                public void onFinish(String response) {
                    Utility.handleWeatherResponse(AutoUpdateService.this, response);
                }

                @Override
                public void onError(Exception e) {

                }
            });
        }
    }

