    @Override
    public void start() {
        mDefaultCityId = FileUtil.getStringFromPreferences(mView.getContext().getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_CITY_ID, Constants.DEFAULT_CITY_ID);
        mIsFirstStartup = FileUtil.getBooleanFromPreferences(mView.getContext().getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_FIRST_STARTUP, true);
        FileUtil.putBooleanToPreferences(mView.getContext().getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_FIRST_STARTUP, false);
        mIsNetworkAvailable = NetUtil.isNetworkAvailable(mView.getContext().getApplicationContext());
        if (mIsNetworkAvailable) {
            mUseCase = new GetCitiesUseCase(mView.getContext().getApplicationContext());
            initLocation();
        }

        if (!mIsNetworkAvailable) {
            gotoNext();
            return;
        }

        mUseCase.execute(new GetCitiesSubscriber());
        mLocationCounter = 0;
        mLocationClient.startLocation();
    }

