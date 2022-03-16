    @Override
    protected void LogContent(List<CityEntity> citys) {
        for (CityEntity city :
                citys) {
            Log.e(TAG, city.toString());
        }
    }

