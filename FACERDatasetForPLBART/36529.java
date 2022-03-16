    /**
     * æŸ¥è¯¢åŽ¿çº§ä»£å?·æ‰€å¯¹åº”çš„å¤©æ°”ä»£å?·
     *
     * @author æ¢?é¹?å®‡ 2016-7-29 ä¸‹å?ˆ2:31:00
     */
    private void queryWeatherCode(String countyCode) {
        String address = "http://www.weather.com.cn/data/list3/city" + countyCode + ".xml";
        queryFromServer(address, "countyCode", null);
    }

