    public void putCityWeather(WeatherEntity weatherEntity, String cityId) {
        if (null == mDiskLruCache || null == weatherEntity || null == cityId)
            return;

        try {
            DiskLruCache.Editor editor = mDiskLruCache.edit(StringUtil.bytesToMd5String((CITY_WEATHER_ENTITY_CACHE_KEY + cityId).getBytes()));
            if (editor != null) {
                editor.set(0, mJsonProcesser.weatherEntityToJson(weatherEntity));
                editor.commit();
                mDiskLruCache.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

