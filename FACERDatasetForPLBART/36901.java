    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK || data == null) {
            return;
        }
        CityInfo city = (CityInfo) data.getSerializableExtra(Extras.CITY);
        CityInfo currentCity = (CityInfo) mACache.getAsObject(Extras.CITY);
        if (!currentCity.equals(city)) {
            mACache.put(Extras.CITY, city);
        }
        if (!mCityList.contains(city)) {
            mCityList.add(0, city);
            mACache.put(Extras.CITY_LIST, mCityList);
        }
        setResult(RESULT_OK, data);
        finish();
    }

