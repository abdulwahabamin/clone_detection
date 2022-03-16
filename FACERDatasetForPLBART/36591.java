    @Override
    public void onDestroy() {
        super.onDestroy();
        // 关闭自动更新�?务时，需�?将定时�?�动更新�?务的定时器�?�消掉
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent i = new Intent(this, AutoUpdateReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, i, 0);
        manager.cancel(pi);
    }

