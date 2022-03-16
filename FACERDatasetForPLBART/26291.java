    private void onWeather(WeatherData weatherData) {
        boolean exist = false;
        List<FollowedCityData> followedCityDatas = mFollowedWeather.getValue();
        for (FollowedCityData followedCityData : followedCityDatas) {
            if (followedCityData.getCityId().equals(weatherData.getCityId())) {
                followedCityData.update(weatherData);
                exist = true;
                break;
            }
        }

        if(!exist) {
            if (CoreManager.getImpl(ILocationApi.class).getLocatedCityId().equals(weatherData.getCityId())) {
                followedCityDatas.add(0, new FollowedCityData(weatherData, FollowedCityHolder.BLUR_IMAGE[(followedCityDatas.size()+1) % FollowedCityHolder.BLUR_IMAGE.length]));
            } else {
                followedCityDatas.add(new FollowedCityData(weatherData, FollowedCityHolder.BLUR_IMAGE[(followedCityDatas.size()+1) % FollowedCityHolder.BLUR_IMAGE.length]));
            }
        }

        mFollowedWeather.setValue(followedCityDatas);
    }

