    /**
     * 查询县级代�?�所对应的天气代�?�
     *
     * @author �?�?宇 2016-7-29 下�?�2:31:00
     */
    private void queryWeatherCode(String countyCode) {
        String address = "http://www.weather.com.cn/data/list3/city" + countyCode + ".xml";
        queryFromServer(address, "countyCode", null);
    }

