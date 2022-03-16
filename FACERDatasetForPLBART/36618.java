    /**
     * è§£æž?å’Œå¤„ç?†æœ?åŠ¡å™¨è¿”å›žçš„çœ?çº§æ•°æ?®
     *
     * @param simpleWeatherDB
     * @param response
     * @return
     */
    public synchronized static boolean handleProvincesResponse(SimpleWeatherDB simpleWeatherDB, String response) {
        if (!TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            if (allProvinces != null && allProvinces.length > 0) {
                for (String p : allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    // å°†è§£æž?å‡ºæ?¥çš„æ•°æ?®å­˜å‚¨åˆ°Provinceè¡¨
                    simpleWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

