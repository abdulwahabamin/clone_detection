    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ib_settings_toolbar_back: {
                onBackPressed();
            } break;
            case R.id.rl_settings_auto_update: {
                showUpdateFreqDialog();
            } break;
            case R.id.ll_settings_notification_weather: {
                boolean shouldNotify = FileUtil.getBooleanFromPreferences(getContext().getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_NOTIFY_WEATHER, Constants.DEFAULT_NOTIFY_WEATHER);
                FileUtil.putBooleanToPreferences(getContext().getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_NOTIFY_WEATHER, !shouldNotify);
                showNotificationWeather(!shouldNotify);
            } break;
            case R.id.ll_settings_about: {
                showAboutDialog();
            } break;
        }
    }

