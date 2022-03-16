    /**
     * 解�?和处�?��?务器返回的县级数�?�
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
                    // 将解�?出�?�的数�?�存储到County表
                    simpleWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }

