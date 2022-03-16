    /**
     * 通过�??字或者拼音�?�索
     *
     * @param cityName 市,county 县
     * @return 结果
     */
    @Override
    @WorkerThread
    public City searchCity(final String cityName,final String county) {
        return mCityDatabase.cityDao().searchCity(cityName,county);
    }

