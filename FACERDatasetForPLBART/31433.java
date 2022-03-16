    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtil.e(TAG, "onStartCommand");
        LogUtil.e(TAG, "pid=" + Process.myPid());
        LogUtil.e(TAG, "uid=" + Process.myUid());

        String cityId = null;
        if (intent != null) {
            cityId = intent.getStringExtra(UPDATE_CITY_ID);
        }
        if (cityId != null) {
            mCityId = cityId;
            mUseCase.setCityId(mCityId);
            LogUtil.e(TAG, "upate cityid to " + cityId);
        }

        boolean shouldUpdateData = true;
        if (intent != null && !intent.getBooleanExtra(UPDATE_DATA_FLAG, true)) {
            shouldUpdateData = false;
        }

        if (shouldUpdateData) {
            mUseCase.execute(new CityWeatherSubscriber());
        }

        int updateFreq = FileUtil.getIntFromPreferences(getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_UPDATE_FREQUENCY, Constants.DEFAULT_UPDATE_FREQUENCY);
        setUpdateServiceAlarm(getApplicationContext(), updateFreq);
        LogUtil.e(TAG, "updateFreq=" + updateFreq);

        return super.onStartCommand(intent, flags, startId);
    }

