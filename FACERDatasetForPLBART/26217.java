    @Override
    @WorkerThread
    public List<City> queryAllCities() {
        if(mAllCityData.size() > 0){
            return mAllCityData;
        }
        mAllCityData = mCityDatabase.cityDao().getAll();
        return mAllCityData;
    }

