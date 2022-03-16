    @Override
    public List<LifeIndex> getLifeIndexes() {
        List<LifeIndex> lifeIndexes = new ArrayList<>();
        String cityId = miWeather.getForecast().getCityId();
        for (MiIndex miIndex : miWeather.getIndexList()) {
            lifeIndexes.add(new LifeIndex(cityId, miIndex.getName(), miIndex.getIndex(), miIndex.getDetails()));
        }
        return lifeIndexes;
    }

