    /**
     * 解�?和处�?��?务器返回的市级数�?�
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
                    // 将解�?出�?�的数�?�存储到City表
                    simpleWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

