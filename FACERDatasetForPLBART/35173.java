    @Override
    public Long getKey(ProvinceEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

