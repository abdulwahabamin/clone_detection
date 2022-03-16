    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK || data == null) {
            return;
        }

        CityInfo city = (CityInfo) data.getSerializableExtra(Extras.CITY);
        if (mCity.equals(city)) {
            return;
        }

        mCity = city;
        view.setTitle(mCity.name);
        view.scrollToTopAndExpand();
        view.hideWeatherView();
        view.setRefreshing(true);
        onRefresh();
    }

