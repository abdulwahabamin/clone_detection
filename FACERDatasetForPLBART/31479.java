    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        mPresenter.stop();
        String cityId = intent.getStringExtra(CITY_ID);
        FileUtil.putStringToPreferences(getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_CITY_ID, cityId);
        mPresenter.setCityId(cityId);
        mPresenter.start();
    }

