    @Override
    public void showProvince(List<CityEntity> provinceList) {
        rvCity.scrollToPosition(0);
        cityEntityList.clear();
        cityEntityList.addAll(provinceList);
        adapter.notifyDataSetChanged();
    }

