    @Override
    protected void LogContent(List<CityEntity> cityEntities) {
        for (CityEntity entity :
                cityEntities) {
            logger.info(entity.toString());
        }
    }

