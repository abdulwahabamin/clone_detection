    /**
     * 查询天气代�?�所对应的天气
     *
     * @author �?�?宇 2016-7-29 下�?�2:31:17
     */
    private void queryWeatherInfo(String weatherCode) {
        String address = "http://wthrcdn.etouch.cn/weather_mini?citykey=" + weatherCode;
        queryFromServer(address, "weatherCode", weatherCode);
    }

