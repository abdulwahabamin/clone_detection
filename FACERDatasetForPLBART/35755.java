    @Override
    public List<LifeIndex> getLifeIndexes() {

        List<LifeIndex> indexList = new ArrayList<>();
        List<KnowWeather.LifeIndexEntity> lifeIndexEntityList = knowWeather.getLifeIndex();
        for (KnowWeather.LifeIndexEntity lifeIndexEntity : lifeIndexEntityList) {
            LifeIndex lifeIndex = new LifeIndex();
            lifeIndex.setCityId(knowWeather.getCityId());
            lifeIndex.setName(lifeIndexEntity.getName());
            lifeIndex.setIndex(lifeIndexEntity.getLevel());
            lifeIndex.setDetails(lifeIndexEntity.getContent());
            indexList.add(lifeIndex);
        }
        return indexList;
    }

