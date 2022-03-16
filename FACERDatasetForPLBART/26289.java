    public void deleteFollowedWeather(String cityId) {
        CoreManager.getImpl(IWeatherProvider.class).deleteWeather(cityId);

        if(CoreManager.getImpl(ICityProvider.class).getCurrentCityId().equals(cityId)) {
            String locationId = CoreManager.getImpl(ILocationApi.class).getLocatedCityId();
            CoreManager.getImpl(ICityProvider.class).saveCurrentCityId(locationId);
            CoreManager.getImpl(IWeatherProvider.class).updateWeather(locationId);
        }

        List<FollowedCityData> followedCityDatas = mFollowedWeather.getValue();
        for (FollowedCityData followedCityData : followedCityDatas) {
            if (followedCityData.getCityId().equals(cityId)) {
                followedCityDatas.remove(followedCityData);
                break;
            }
        }

        mFollowedWeather.setValue(followedCityDatas);
    }

