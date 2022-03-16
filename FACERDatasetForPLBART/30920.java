    public void putWeatherConditionEntities(List<WeatherConditionEntity> weatherConditionEntities) {
        if (null == mDiskLruCache || null == weatherConditionEntities)
            return;

        try {
            DiskLruCache.Editor editor = mDiskLruCache.edit(StringUtil.bytesToMd5String(WEATHER_CONDITION_ENTITIES_CACHE_KEY.getBytes()));
            if (editor != null) {
                editor.set(0, mJsonProcesser.weatherConditionEntitiesToJson(weatherConditionEntities));
                editor.commit();
                mDiskLruCache.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

