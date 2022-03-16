    public void putCityEntities(List<CityEntity> cityEntities) {
        if (null == mDiskLruCache || null == cityEntities)
            return;

        try {
            DiskLruCache.Editor editor = mDiskLruCache.edit(StringUtil.bytesToMd5String(CITY_ENTITIES_CACHE_KEY.getBytes()));
            if (editor != null) {
                editor.set(0, mJsonProcesser.cityEntitiesToJson(cityEntities));
                editor.commit();
                mDiskLruCache.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

