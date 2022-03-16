    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mPresenter = null;
        mParent = null;
        mMainView = null;
        mForecastView = null;
        mCurWeatherView = null;
        mLifeIndexView = null;
        mContext = null;
        mWeatherEntity = null;
        mListForecasts.clear();
        mListForecasts = null;
        mListLifeIndex.clear();
        mListLifeIndex = null;
        mListWeatherInfo.clear();
        mListWeatherInfo = null;
    }

