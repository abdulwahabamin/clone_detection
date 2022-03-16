    @Override
    public Long getKey(OrmCity entity) {
        if(entity != null) {
            return entity.get_id();
        } else {
            return null;
        }
    }

