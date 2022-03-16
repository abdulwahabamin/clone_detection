    @Override
    public List<LifeIndex> getLifeIndexes() {

        EnvironmentCloudForecast.SuggestionEntity suggestionEntity = cloudForecast.getSuggestion();

        List<LifeIndex> indexList = new ArrayList<>();

        LifeIndex index1 = new LifeIndex();
        index1.setCityId(cloudForecast.getCityId());
        index1.setName("空气质�?");
        index1.setIndex(suggestionEntity.getAir().getBrf());
        index1.setDetails(suggestionEntity.getAir().getTxt());
        indexList.add(index1);

        LifeIndex index2 = new LifeIndex();
        index2.setCityId(cloudForecast.getCityId());
        index2.setName("舒适度");
        index2.setIndex(suggestionEntity.getComf().getBrf());
        index2.setDetails(suggestionEntity.getComf().getTxt());
        indexList.add(index2);

        LifeIndex index3 = new LifeIndex();
        index3.setCityId(cloudForecast.getCityId());
        index3.setName("穿衣");
        index3.setIndex(suggestionEntity.getDrs().getBrf());
        index3.setDetails(suggestionEntity.getDrs().getTxt());
        indexList.add(index3);

        LifeIndex index4 = new LifeIndex();
        index4.setCityId(cloudForecast.getCityId());
        index4.setName("感冒");
        index4.setIndex(suggestionEntity.getFlu().getBrf());
        index4.setDetails(suggestionEntity.getFlu().getTxt());
        indexList.add(index4);

        LifeIndex index5 = new LifeIndex();
        index5.setCityId(cloudForecast.getCityId());
        index5.setName("�?动");
        index5.setIndex(suggestionEntity.getSport().getBrf());
        index5.setDetails(suggestionEntity.getSport().getTxt());
        indexList.add(index5);

        LifeIndex index6 = new LifeIndex();
        index6.setCityId(cloudForecast.getCityId());
        index6.setName("旅游");
        index6.setIndex(suggestionEntity.getTrav().getBrf());
        index6.setDetails(suggestionEntity.getTrav().getTxt());
        indexList.add(index6);

        LifeIndex index7 = new LifeIndex();
        index7.setCityId(cloudForecast.getCityId());
        index7.setName("紫外线");
        index7.setIndex(suggestionEntity.getUv().getBrf());
        index7.setDetails(suggestionEntity.getUv().getTxt());
        indexList.add(index7);

        LifeIndex index8 = new LifeIndex();
        index8.setCityId(cloudForecast.getCityId());
        index8.setName("洗车");
        index8.setIndex(suggestionEntity.getCw().getBrf());
        index8.setDetails(suggestionEntity.getCw().getTxt());
        indexList.add(index8);

        return indexList;
    }

