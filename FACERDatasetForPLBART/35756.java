    @Override
    public AirQualityLive getAirQualityLive() {

        KnowWeather.AqiEntity aqiEntity = knowWeather.getAqi();
        AirQualityLive airQualityLive = new AirQualityLive();
        airQualityLive.setCityId(knowWeather.getCityId());
        airQualityLive.setAqi(Integer.parseInt(aqiEntity.getAqi()));
        airQualityLive.setPm25(Integer.parseInt(aqiEntity.getPm25()));
        airQualityLive.setPm10(Integer.parseInt(aqiEntity.getPm10()));
        airQualityLive.setAdvice(aqiEntity.getAdvice());
        airQualityLive.setCityRank(aqiEntity.getCityRank());
        airQualityLive.setQuality(aqiEntity.getQuality());
        return airQualityLive;
    }

