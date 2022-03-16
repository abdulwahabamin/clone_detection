    @Override
    public void showCity(List<CityEntity> cityList) {
        rvCity.scrollToPosition(0);
        cityEntityList.clear();
        cityEntityList.addAll(cityList);
        adapter.notifyDataSetChanged();
    }

