    @Inject
    CityDao(Context context) {

        this.cityDaoOperation = CityDatabaseHelper.getInstance(context).getCityDao(City.class);
        this.hotCityDaoOperation = CityDatabaseHelper.getInstance(context).getCityDao(HotCity.class);
    }

