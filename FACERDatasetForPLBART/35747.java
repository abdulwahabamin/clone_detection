    @Override
    public AirQualityLive getAirQualityLive() {

        AirQualityLive airQualityLive = new AirQualityLive();
//        airQualityLive.setAdvice("");
        airQualityLive.setAqi(Integer.parseInt(cloudCityAirLive.getAqi()));
        airQualityLive.setCityId(cloudCityAirLive.getCityId());
//        airQualityLive.setCityRank("");
        airQualityLive.setCo(cloudCityAirLive.getCo());
        airQualityLive.setNo2(cloudCityAirLive.getNo2());
        airQualityLive.setO3(cloudCityAirLive.getO3());
        airQualityLive.setPm10(Integer.parseInt(cloudCityAirLive.getPm10()));
        airQualityLive.setPm25(Integer.parseInt(cloudCityAirLive.getPm25()));
        airQualityLive.setPrimary(cloudCityAirLive.getPrimary());
        airQualityLive.setPublishTime(cloudCityAirLive.getTime());
        airQualityLive.setQuality(getAqiQuality(airQualityLive.getAqi()));
        airQualityLive.setSo2(cloudCityAirLive.getSo2());
        return airQualityLive;
    }

