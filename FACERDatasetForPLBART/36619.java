    /**
     * è§£æž?å’Œå¤„ç?†æœ?åŠ¡å™¨è¿”å›žçš„å¸‚çº§æ•°æ?®
     *
     * @param simpleWeatherDB
     * @param response
     * @param provinceId
     * @return
     */
    public static boolean handleCitiesResponse(SimpleWeatherDB simpleWeatherDB, String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCities = response.split(",");
            if (allCities != null && allCities.length > 0) {
                for (String c : allCities) {
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    // å°†è§£æž?å‡ºæ?¥çš„æ•°æ?®å­˜å‚¨åˆ°Cityè¡¨
                    simpleWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

