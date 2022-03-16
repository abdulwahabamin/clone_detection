    private void startServices() {
        int updateFreq = FileUtil.getIntFromPreferences(getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_UPDATE_FREQUENCY, Constants.DEFAULT_UPDATE_FREQUENCY);
        if (updateFreq != 0) {
            Intent intent1 = new Intent(this.getApplicationContext(), WeatherUpdateService.class);
            intent1.putExtra(WeatherUpdateService.UPDATE_DATA_FLAG, false);
            startService(intent1);
        }

        boolean shouldNotify = FileUtil.getBooleanFromPreferences(getApplicationContext(), Constants.GLOBAL_SETTINGS, Constants.PRF_KEY_NOTIFY_WEATHER, Constants.DEFAULT_NOTIFY_WEATHER);
        if (shouldNotify) {
            Intent intent2 = new Intent(this.getApplicationContext(), WeatherNotificationService.class);
            startService(intent2);
        }
    }

