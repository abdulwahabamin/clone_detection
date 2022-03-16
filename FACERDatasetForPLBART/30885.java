    @Override
    protected void LogContent(List<WeatherConditionEntity> weatherConditionEntities) {
        for (WeatherConditionEntity entity :
                weatherConditionEntities) {
            Log.e(TAG, entity.toString());
        }
    }

