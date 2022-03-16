    @PerActivity
    @Provides
    CityWeatherFavoriteContract.Presenter providesPresenter(DataManager dataManager) {

        return new CityWeatherFavoritePresenter(dataManager);
    }

