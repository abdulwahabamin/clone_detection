    @Override
    public void showArea(List<CityEntity> areaList) {
        rvCity.scrollToPosition(0);
        cityEntityList.clear();
        cityEntityList.addAll(areaList);
        adapter.notifyDataSetChanged();
    }

