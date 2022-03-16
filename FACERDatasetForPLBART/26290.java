    @MainThread
    private  void parseFollowedWeathers(List<WeatherData> weatherDatas) {
        List<FollowedCityData> followedCityDatas = mFollowedWeather.getValue();
        followedCityDatas.clear();

        for(int index =0;index<weatherDatas.size();index++) {
            WeatherData weatherData = weatherDatas.get(index);
            if (weatherData != null) {
                if (weatherData.getCityId().equals(CoreManager.getImpl(ILocationApi.class).getLocatedCityId())) {
                    followedCityDatas.add(0, new FollowedCityData(weatherData, FollowedCityHolder.BLUR_IMAGE[index % FollowedCityHolder.BLUR_IMAGE.length]));
                } else {
                    followedCityDatas.add(new FollowedCityData(weatherData, FollowedCityHolder.BLUR_IMAGE[index % FollowedCityHolder.BLUR_IMAGE.length]));
                }
            }
        }
        mFollowedWeather.postValue(followedCityDatas);
    }

