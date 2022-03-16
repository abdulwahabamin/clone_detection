    @Override
    public void showSearchSuccess(List<CityEntity> searchList) {
        tvSearchTips.setVisibility(View.GONE);
        rvCity.setVisibility(View.VISIBLE);
        rvCity.scrollToPosition(0);
        cityEntityList.clear();
        cityEntityList.addAll(searchList);
        adapter.notifyDataSetChanged();
    }

