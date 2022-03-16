    @Override
    public void updateItem(LifeIndexData lifeIndexData, int position) {
        List<WeatherData.LifeIndexEntity> lifeIndexesData = lifeIndexData.lifeIndexesData;
        if (Check.isNull(lifeIndexData)) {
            return;
        }
        try {
            List<LifeItemData> lifeItems = new ArrayList<>();
            for (int index = 0; index < lifeIndexesData.size(); index++) {
                lifeIndexesData.get(index).setName(LIFE_INDEXES[index]);
                lifeItems.add(new LifeItemData(lifeIndexesData.get(index), LIFE_INDEXES_ICONIDS[index]));
            }
            mLifeAdapter.setData(lifeItems);
        }catch (Exception e) {
            LogHelper.error(TAG,"updateItem error %s",e);
        }


    }

