    @Override
    protected void LogContent(List<WeatherConditionEntity> weatherConditionEntities) {
        for (WeatherConditionEntity entity :
                weatherConditionEntities) {
            logger.info(entity.toString());
        }
    }

