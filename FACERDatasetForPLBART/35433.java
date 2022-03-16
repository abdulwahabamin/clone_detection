    public SearchResultPresenter(SearchResultContract.View view) {
        mView = view;
        mRepository = CityRepository.getInstance();
        mWeatherRepository = WeatherRepository.getInstance();
        mView.setPresenter(this);
    }

