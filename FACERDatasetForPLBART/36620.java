    /**
     * è§£æž?å’Œå¤„ç?†æœ?åŠ¡å™¨è¿”å›žçš„åŽ¿çº§æ•°æ?®
     *
     * @param simpleWeatherDB
     * @param response
     * @param cityId
     * @return
     */
    public static boolean handleCountiesResponse(SimpleWeatherDB simpleWeatherDB, String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0) {
                for (String c : allCounties) {
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    // å°†è§£æž?å‡ºæ?¥çš„æ•°æ?®å­˜å‚¨åˆ°Countyè¡¨
                    simpleWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }

