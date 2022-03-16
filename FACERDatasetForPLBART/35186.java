    @Override
    public Long getKey(WeatherEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

