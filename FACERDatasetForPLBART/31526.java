    @Override
    public void onDialogItemClick(int which) {
        FileUtil.putIntToPreferences(getContext().getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_UPDATE_FREQUENCY, which);
        showAutoUpdateFrequency(getContext().getApplicationContext().getResources().getStringArray(R.array.update_frequency_string)[which]);

        if (WeatherUpdateService.isUpdateServeceAlarmOn(getApplicationContext())) {
            WeatherUpdateService.setUpdateServiceAlarm(getApplicationContext(), 0);
        }
        WeatherUpdateService.setUpdateServiceAlarm(getApplicationContext(), which);
        if (0 == which) {
            stopService(new Intent(getApplicationContext(), WeatherUpdateService.class));
        }
    }

