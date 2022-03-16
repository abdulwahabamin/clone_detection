    public CityWeatherAdapter(Context mContext, CityWeatherPresenter presenter, ViewGroup parent) {
        this.mContext = mContext;
        mPresenter = presenter;
        mParent = parent;

        mMainView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_city_weather_main, parent, false);
        mMainView.setTag(VIEW_MAIN);
        mForecastView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_city_weather_forecast, parent, false);
        mForecastView.setTag(VIEW_FORECAST);
        mCurWeatherView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_city_weather_cur_weather_info, parent, false);
        mCurWeatherView.setTag(VIEW_CURRENT_WEATHER_INFO);
        mLifeIndexView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_city_weather_life_index, parent, false);
        mLifeIndexView.setTag(VIEW_LIFE_INDEX);
    }

