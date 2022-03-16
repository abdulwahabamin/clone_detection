    @Override
    public void start() {
        int updateFrequency = FileUtil.getIntFromPreferences(mView.getContext().getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_UPDATE_FREQUENCY, Constants.DEFAULT_UPDATE_FREQUENCY);
        String[] updateFrequencyString = mView.getContext().getApplicationContext().getResources().getStringArray(R.array.update_frequency_string);
        mView.showAutoUpdateFrequency(updateFrequencyString[updateFrequency]);

        boolean shouldNotify = FileUtil.getBooleanFromPreferences(mView.getContext().getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_NOTIFY_WEATHER, Constants.DEFAULT_NOTIFY_WEATHER);
        mView.showNotificationWeather(shouldNotify);
    }

