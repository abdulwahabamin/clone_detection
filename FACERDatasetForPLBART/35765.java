    @Override
    public AirQualityLive getAirQualityLive() {
        MiAQI aqiEntity = miWeather.getAqi();
        AirQualityLive airQualityLive = new AirQualityLive();
        airQualityLive.setCityId(String.valueOf(miWeather.getAqi().getCityId()));
        airQualityLive.setAqi(aqiEntity.getAqi());
        airQualityLive.setPm25(aqiEntity.getPm25());
        airQualityLive.setPm10(aqiEntity.getPm10());
        airQualityLive.setAdvice("");
        airQualityLive.setCityRank("");
        airQualityLive.setQuality(aqiEntity.getSrc());
        return airQualityLive;
    }

