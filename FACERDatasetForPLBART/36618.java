    /**
     * 解�?和处�?��?务器返回的�?级数�?�
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
                    // 将解�?出�?�的数�?�存储到Province表
                    simpleWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

