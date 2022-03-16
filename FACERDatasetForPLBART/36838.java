    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) {
            return super.onStartCommand(null, flags, startId);
        }

        SharedPrefsHelper prefsHelper = new SharedPrefsHelper(this);

        List<County> countyList;
        County countyExtra = (County) intent.getSerializableExtra(Consts.EXTRA_COUNTY);
        if (countyExtra == null) {
            countyList = prefsHelper.getCounties();
        } else {
            countyList = new ArrayList<>();
            countyList.add(countyExtra);
        }

        for (final County county : countyList) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    WeatherInfoDAO dao = new WeatherInfoDAO(FetchWeatherInfoService.this);
                    WeatherInfo info = WeatherInfoFetcher.fetch(county);
                    if (info != null) {
                        dao.save(info);
                    }
                    dao.close();
                    L.v(TAG, "Fetched weather info of " + county.getName());
                }
            }).start();
        }

        if (intent.getBooleanExtra(Consts.EXTRA_AUTO_UPDATE, false)) {
            AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
            long triggerAtTime = SystemClock.elapsedRealtime() + 4 * 60 * 60 * 1000;
            Intent i = new Intent(this, AutoUpdateReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
            manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
        }

        return super.onStartCommand(intent, flags, startId);
    }

