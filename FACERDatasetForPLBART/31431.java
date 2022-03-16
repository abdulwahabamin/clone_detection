    @Override
    public void onCreate() {
        LogUtil.e(TAG, "onCreate");
        LogUtil.e(TAG, "pid=" + Process.myPid());
        LogUtil.e(TAG, "uid=" + Process.myUid());
        super.onCreate();
        mCityId = FileUtil.getStringFromPreferences(getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_CITY_ID, Constants.DEFAULT_CITY_ID);
        LogUtil.e(TAG, "cityid=" + mCityId);
        mUseCase = new GetCityWeatherUseCase(getApplicationContext(), mCityId, false);
    }

