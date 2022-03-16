    @Override
    public Long getKey(CityEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

