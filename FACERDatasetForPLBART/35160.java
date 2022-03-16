    @Override
    public Long getKey(LoveCityEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

