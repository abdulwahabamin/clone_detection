    public CityPresenter(CityContract.CityView view){
        mView = view;
        mView.setPresenter(this);
        mCityRepository = CityRepository.getInstance();
        mWeatherRepository = WeatherRepository.getInstance();
    }

