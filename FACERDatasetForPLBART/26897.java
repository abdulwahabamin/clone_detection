    @Override
    public Long getKey(OrmWeather entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

