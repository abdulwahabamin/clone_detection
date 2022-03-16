    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                updateWeather();
            }

        }).start();

        if (intent != null && intent.getIntExtra("anHour", 2) != -1) {
            anHour = intent.getIntExtra("anHour", 2) * 60 * 60 * 1000;
        } else {
            SharedPreferences prefs = getSharedPreferences("data_setting", MODE_PRIVATE);
            int temp = prefs.getInt("update_frequency", 1);
            switch (temp) {
                case 0:
                    anHour = 1 * 60 * 60 * 1000;
                    break;
                case 1:
                    anHour = 2 * 60 * 60 * 1000;
                    break;
                case 2:
                    anHour = 5 * 60 * 60 * 1000;
                    break;
                case 3:
                    anHour = 8 * 60 * 60 * 1000;
                    break;
                default:
                    break;
            }
        }
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
        Intent i = new Intent(this, AutoUpdateReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);
        return super.onStartCommand(intent, flags, startId);
    }

