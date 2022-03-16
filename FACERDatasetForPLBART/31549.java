    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (VIEW_MAIN == viewType && mMainView != null) {
            return new MainViewHolder(mMainView);
        } else if (VIEW_FORECAST == viewType && mForecastView != null) {
            return new ForecastViewHolder(mForecastView);
        } else if (VIEW_CURRENT_WEATHER_INFO == viewType && mCurWeatherView != null) {
            return new CurWeatherInfoViewHolder(mCurWeatherView);
        } else if (mLifeIndexView != null) {
            return new LifeIndexViewHolder(mLifeIndexView, mPresenter);
        } else {
            return null;
        }
    }

