    /**
     * 拆分天气
     *
     * @param weather 如：晴转多云
     * @return {"晴", "多云"}
     */
    private String[] splitWeather(String weather) {

        if (weather == null) {
            return new String[]{"", ""};
        }
        if (weather.contains("转")) {
            return weather.split("转");
        } else {
            return new String[]{weather, weather};
        }
    }

