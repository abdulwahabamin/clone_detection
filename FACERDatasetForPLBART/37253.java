    @Override
    public Weather getCurrentWeatherFromCache() {
        CityInfo cityInfo = (CityInfo) mACache.getAsObject(Extras.CITY);
        if (cityInfo == null) {
            return null;
        }
        return (Weather) mACache.getAsObject(cityInfo.name);
    }

